package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private String role;
    private String content;
}
