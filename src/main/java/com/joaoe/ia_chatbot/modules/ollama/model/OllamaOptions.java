package com.joaoe.ia_chatbot.modules.ollama.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ollama_options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OllamaOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @DecimalMin("0.0")
    @DecimalMax("1.0")
    @Column(precision = 2, scale = 1)
    private BigDecimal temperature;    
    
    @DecimalMin("0.1")
    @DecimalMax("1.0")
    @Column(precision = 2, scale = 1)
    private BigDecimal top_p;

    private Integer num_predict;
}
