package com.joaoe.ia_chatbot.modules.ollama.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestOllamaConfig {

    @NotBlank(message = "Model name cannot be blank")
    private String model;

    private String prompt;
    private String suffix;
    private String images;

    private boolean think;

    private String format;
    private String system;
    private String template;

    @Valid
    private RequestOllamaOptions options;

    private boolean stream;
    private boolean raw;

    @Pattern(
        regexp = "^(\\d+)(s|m|h)?$",
        message = "KeepAlive must be a number followed by s (seconds), m (minutes), or h (hours), e.g., 30s or 5m"
    )
    private String keepAlive;
}
