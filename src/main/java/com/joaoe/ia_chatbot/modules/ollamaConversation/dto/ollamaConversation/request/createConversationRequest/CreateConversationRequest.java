package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.request.createConversationRequest;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateConversationRequest {

    @NotNull
    private UUID customerUuid;
}
