package com.binde.tailorapplication.service;

import com.binde.tailorapplication.entity.Designer;

public interface EmailService {

    void sendForgotPasswordEmail(Designer user, String otp) throws Exception;

    //FOR account creation
    void sendAccountCreationNotification(String firstname, String lastname, String email);
}
