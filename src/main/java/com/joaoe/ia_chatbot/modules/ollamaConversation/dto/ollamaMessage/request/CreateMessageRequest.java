package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMessageRequest {

    @NotBlank(message = "role: invalid role")
    private String role;

    @NotBlank(message = "content: invalid content")
    private String content;
}
