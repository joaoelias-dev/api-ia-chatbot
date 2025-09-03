package com.joaoe.ia_chatbot.modules.appointment.exception;

public abstract class AppointmentException extends RuntimeException {
    protected AppointmentException(String message){
        super(message);
    }

    protected AppointmentException(String message, Throwable cause){
        super(message, cause);
    }
}
