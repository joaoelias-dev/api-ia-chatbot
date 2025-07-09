package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.response.createOllamaConversation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OllamaConversationCustomer {
    private UUID uuid;
    private String fullName;
}
