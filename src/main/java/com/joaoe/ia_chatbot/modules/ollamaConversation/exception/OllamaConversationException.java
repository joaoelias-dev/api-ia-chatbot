package com.joaoe.ia_chatbot.modules.ollamaConversation.exception;

public abstract class OllamaConversationException extends RuntimeException{
    protected OllamaConversationException(String message){
        super(message);
    }

    protected OllamaConversationException(String message, Throwable cause){
        super(message, cause);
    }
}
