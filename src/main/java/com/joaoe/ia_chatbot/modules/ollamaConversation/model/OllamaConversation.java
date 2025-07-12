package com.joaoe.ia_chatbot.modules.ollamaConversation.model;

import com.joaoe.ia_chatbot.modules.customer.model.Customer;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ollama_conversations")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OllamaConversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "created_at")
    private Instant created_at;

    @Column(name = "updated_at")
    private Instant lastUpdatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OllamaMessage> messages;

    @ManyToOne
    @JoinColumn(name = "ollama_config_id")
    private OllamaConfig ollamaConfig;
}
