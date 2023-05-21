package com.binde.tailorapplication.service;

import com.binde.tailorapplication.dto.request.*;
import com.binde.tailorapplication.dto.response.DesignerResponseDTO;
import com.binde.tailorapplication.dto.response.LoginResponse;
import com.binde.tailorapplication.dto.response.UserResponseDto;
import com.binde.tailorapplication.entity.Designer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;

public interface DesignerService {
    Designer findByEmail(String email);
    LoginResponse login(LoginDTO request);
    DesignerResponseDTO updateDesignerDetials(UpdateDesigner updateUserDto);

    DesignerResponseDTO createUser(DesignerDTO designerDTO);

    UserResponseDto saveOAuth2User(Designer request);

    DesignerResponseDTO getDesigner(String Id);

    String updatePassword(UpdatePasswordDto updatePasswordDto);

    void deleteDesigner(String email);
    LoginResponse loginWithGoogle(Oauth2Request request) throws GeneralSecurityException, IOException;
    DesignerResponseDTO getDesignerProfile(HttpServletRequest request);


}

