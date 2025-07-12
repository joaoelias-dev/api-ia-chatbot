package com.joaoe.ia_chatbot.modules.ollamaConversation.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ollama_messages")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class OllamaMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "uuid", insertable = false, updatable = false)
    private UUID uuid;

    @Column(name = "role")
    private String role;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Instant createdAt;

    // @Column(name = "updated_at")
    // private Instant updatedAt;

    // @Column(name = "deleted_at")
    // private Instant deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conversation_id")
    private OllamaConversation conversation;
}
