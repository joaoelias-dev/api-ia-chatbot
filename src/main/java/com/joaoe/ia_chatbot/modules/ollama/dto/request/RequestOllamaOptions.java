package com.joaoe.ia_chatbot.modules.ollama.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class RequestOllamaOptions {
    
    @DecimalMin(value = "0.0", message = "Temperature must be greater than or equal to 0.0")
    @DecimalMax(value = "1.0", message = "Temperature must be less than or equal to 1.0")
    private BigDecimal temperature;

    @NotNull(message = "TopP is required")
    @DecimalMin(value = "0.1", message = "TopP must be greater than or equal to 0.1")
    @DecimalMax(value = "1.0", message = "TopP must be less than or equal to 1.0")
    private BigDecimal topP;

    @NotNull(message = "numPredict is required")
    @Min(value = 1, message = "numPredict must be at least 1")
    @Max(value = 10000, message = "numPredict must be less than or equal to 10000")
    private Integer numPredict;
}
