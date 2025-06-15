package com.joaoe.ia_chatbot.modules.user.exception;

public class UsernameAlreadyExistsException extends UserException {
    public UsernameAlreadyExistsException(String username) {
        super(String.format("Username '%s' already existes", username));
    }
}
