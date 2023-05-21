package com.binde.tailorapplication.service;

import com.binde.tailorapplication.dto.request.ForgotPasswordDto;
import com.binde.tailorapplication.dto.request.ResetPasswordRequest;
import com.binde.tailorapplication.dto.response.MessageResponse;

//public interface AuthService {
    public interface AuthService {
        MessageResponse resetUserSecurityDetails(ResetPasswordRequest resetPasswordRequest);

        String passwordRequest(ForgotPasswordDto forgotPasswordDto);
    }
//    MessageResponse resetUserSecurityDetails(ResetPasswordRequest resetPasswordRequest);
//
//    MessageResponse resetUserSecurityDetails(ResetPasswordRequest resetPasswordRequest);
//
//    MessageResponse resetUserSecurityDetails(ResetPasswordRequest resetPasswordRequest);
//
//    String passwordRequest(ForgotPasswordDto forgotPasswordDto);
//}
