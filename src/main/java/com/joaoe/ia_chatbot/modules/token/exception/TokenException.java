package com.joaoe.ia_chatbot.modules.token.exception;

public abstract class TokenException extends RuntimeException{
    protected TokenException(String message){
        super(message);
    }

    protected TokenException(String message, Throwable cause){
        super(message, cause);
    }
}
