package com.joaoe.ia_chatbot.modules.ollama.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMessageOllamaDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "O campo 'model' é obrigatório")
    private String model;

    @NotBlank(message = "O campo 'prompt' é obrigatório")
    private String prompt;

    private boolean stream;
    
}
