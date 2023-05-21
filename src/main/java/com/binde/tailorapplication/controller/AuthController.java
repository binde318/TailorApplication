package com.binde.tailorapplication.controller;

import com.binde.tailorapplication.dto.request.*;
import com.binde.tailorapplication.dto.response.AppResponse;
import com.binde.tailorapplication.dto.response.DesignerResponseDTO;
import com.binde.tailorapplication.dto.response.LoginResponse;
import com.binde.tailorapplication.dto.response.MessageResponse;
import com.binde.tailorapplication.exception.BadRequestException;
import com.binde.tailorapplication.service.AuthService;
import com.binde.tailorapplication.service.DesignerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.security.GeneralSecurityException;

import static com.binde.tailorapplication.security.jwt.TokenProvider.doesBothStringMatch;
import static com.binde.tailorapplication.utils.SecurityConstants.PASSWORD_NOT_MATCH_MSG;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final DesignerService userService;
    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDTO request){
        return ResponseEntity.ok().body(AppResponse.buildSuccessTxn(userService.login(request)));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<AppResponse<?>> registerUser(@RequestBody @Valid final DesignerDTO designerDTO) {
        log.info("controller register: register user :: [{}] ::", designerDTO.getEmail());
        validateDesigner(designerDTO);
        DesignerResponseDTO response = userService.createUser(designerDTO);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/auth/register").toUriString());
        return ResponseEntity.created(uri).body(AppResponse.buildSuccess(response));
    }

    private void validateDesigner(DesignerDTO request) {
        log.info("validating user registration request for email :: {}", request.getEmail());
        if (!doesBothStringMatch(request.getConfirmPassword(), request.getPassword())) {
            throw new BadRequestException(PASSWORD_NOT_MATCH_MSG);
        }
        log.info("successful validation for user registration request for email :: {}", request.getEmail());
    }


    @PostMapping("/forgot-password-request")
    public ResponseEntity<?> passwordRequestReset(@RequestBody ForgotPasswordDto forgotPasswordDto) {
        String str = authService.passwordRequest(forgotPasswordDto);
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

    @PostMapping(value = "/reset-password")
    public ResponseEntity<MessageResponse> resetPasswordWithOtp(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        return new ResponseEntity<>(authService.resetUserSecurityDetails(resetPasswordRequest), HttpStatus.ACCEPTED);
    }


    @PutMapping("/update-password")
    public ResponseEntity<Object> updatePassword(@Valid  @RequestBody UpdatePasswordDto updatePasswordDto){
        String response = userService.updatePassword(updatePasswordDto);
        return ResponseEntity.ok().body(AppResponse.buildSuccessTxn(response));
    }

    @PostMapping("/login/google")
    public ResponseEntity<Object> loginWithGoogle(@RequestBody Oauth2Request request) throws GeneralSecurityException, IOException {
        LoginResponse loginResponse = userService.loginWithGoogle(request);
        return ResponseEntity.ok().body(AppResponse.buildSuccessTxn(loginResponse));
    }





}

