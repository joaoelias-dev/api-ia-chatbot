package com.joaoe.ia_chatbot.modules.user.exception;

public class EmailAlreadyExistsException extends UserException {
    public EmailAlreadyExistsException(String email) {
        super(String.format("Email '%s' already exists", email));
    }
}
