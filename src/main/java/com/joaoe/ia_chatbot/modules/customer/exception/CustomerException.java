package com.joaoe.ia_chatbot.modules.customer.exception;

public abstract class CustomerException extends RuntimeException {
    protected CustomerException(String message){
    super(message);
  }

    protected CustomerException(String message, Throwable cause){
    super(message, cause);
  }
}
