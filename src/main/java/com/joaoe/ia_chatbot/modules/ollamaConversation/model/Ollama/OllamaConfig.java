package com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ollama_configs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OllamaConfig {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "model")
    private String model;

    @Column(name = "prompt")
    private String prompt;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "images")
    private String images;

    @Column(name = "think")
    private boolean think;

    @Column(name = "format")
    private String format;

    @Column(name = "system")
    private String system;

    @Column(name = "template")
    private String template;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "options_id", referencedColumnName = "id")
    private OllamaOptions options;

    @Column(name = "stream")
    private boolean stream;

    @Column(name = "raw")
    private boolean raw;

    @Column(name = "keep_alive")
    private String keep_alive;
}
