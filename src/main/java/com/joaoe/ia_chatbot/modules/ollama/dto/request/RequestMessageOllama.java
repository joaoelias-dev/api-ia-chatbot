package com.joaoe.ia_chatbot.modules.ollama.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestMessageOllama implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @NotBlank(message = "The 'model' field is required")
    private String model;

    @NotBlank(message = "The 'prompt' field is required")
    private String prompt;

    private boolean stream;

    private String system;
    
}
