package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.response.createOllamaConversation;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class CreateOllamaConversationResponse {

    private UUID uuid;
    private Instant created_at;
    private Instant lastUpdatedAt;
    private OllamaConversationCustomer customer;
}
