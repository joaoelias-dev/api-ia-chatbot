package com.joaoe.ia_chatbot.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.joaoe.ia_chatbot.modules.user.exception.EmailAlreadyExistsException;
import com.joaoe.ia_chatbot.modules.user.exception.PasswordDoNotMatch;
import com.joaoe.ia_chatbot.modules.user.exception.UsernameAlreadyExistsException;
import com.joaoe.ia_chatbot.modules.user.exception.UsernameNotFound;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> validationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        
        List<String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(error -> error.getDefaultMessage())
            .toList();

        ApiError apiError = new ApiError(
            LocalDateTime.now(),
            request.getRequestURI(),
            "Erro de validação nos campos enviados",
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.name(),
            errors
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiError> notSupportedException(HttpRequestMethodNotSupportedException ex){

        ApiError apiError = new ApiError(LocalDateTime.now(),
            null,
            ex.getMessage(),
            HttpStatus.METHOD_NOT_ALLOWED.value(),
            HttpStatus.METHOD_NOT_ALLOWED.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(apiError);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ApiError> emailAlreadyExistsException(EmailAlreadyExistsException ex, HttpServletRequest request){

        ApiError apiError = new ApiError(LocalDateTime.now(),
            request.getRequestURI(),
            ex.getMessage(),
            HttpStatus.CONFLICT.value(),
            HttpStatus.CONFLICT.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(UsernameAlreadyExistsException.class)
    public ResponseEntity<ApiError> usernameAlreadyExistsException(UsernameAlreadyExistsException ex, HttpServletRequest request){

        ApiError apiError = new ApiError(LocalDateTime.now(),
            request.getRequestURI(),
            ex.getMessage(),
            HttpStatus.CONFLICT.value(),
            HttpStatus.CONFLICT.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(PasswordDoNotMatch.class)
    public ResponseEntity<ApiError> passwordsDoNotMatch(PasswordDoNotMatch ex, HttpServletRequest request){
        ApiError apiError = new ApiError(LocalDateTime.now(),
            request.getRequestURI(),
            ex.getMessage(),
            HttpStatus.UNPROCESSABLE_ENTITY.value(),
            HttpStatus.UNPROCESSABLE_ENTITY.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(apiError);
    }

    @ExceptionHandler(UsernameNotFound.class)
    public ResponseEntity<ApiError> usernameNotFound(UsernameNotFound ex, HttpServletRequest request){
        ApiError apiError = new ApiError(LocalDateTime.now(),
            request.getRequestURI(),
            ex.getMessage(),
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ApiError> unsupportedOperationException(UnsupportedOperationException ex, HttpServletRequest request){
        ApiError apiError = new ApiError(LocalDateTime.now(),
            request.getRequestURI(),
            ex.getMessage(),
            HttpStatus.NOT_IMPLEMENTED.value(),
            HttpStatus.NOT_IMPLEMENTED.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(apiError);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> illegalArgumentException(IllegalArgumentException ex){
        ApiError apiError = new ApiError(LocalDateTime.now(),
            "",
            ex.getMessage(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            HttpStatus.INTERNAL_SERVER_ERROR.name(),
            List.of(ex.getMessage())
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
