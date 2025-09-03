package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.ollamaMessageApi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessagesOllama {
    private String role;
    private String content;
}
