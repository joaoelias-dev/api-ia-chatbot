package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConfig.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOllamaOptionsRequest {

    @DecimalMin("0.0")
    @DecimalMax("1.0")
    private BigDecimal temperature;

    @DecimalMin("0.1")
    @DecimalMax("1.0")
    private BigDecimal top_p;

    private Integer num_predict;
}
