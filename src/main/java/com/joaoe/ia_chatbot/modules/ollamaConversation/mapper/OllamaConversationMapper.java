package com.joaoe.ia_chatbot.modules.ollamaConversation.mapper;

import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.response.CreateOllamaConversationResponse;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.response.OllamaConversationCustomer;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OllamaConversationMapper {

    public CreateOllamaConversationResponse createOllamaConversationResponse(OllamaConversation entity) {
        return CreateOllamaConversationResponse.builder()
                .uuid(entity.getUuid())
                .lastUpdatedAt(entity.getLastUpdatedAt())
                .created_at(entity.getCreated_at())
                .customer(toCustomer(entity))
                .build();
    }

    private OllamaConversationCustomer toCustomer(OllamaConversation entity) {
        var customer = entity.getCustomer();
        return OllamaConversationCustomer.builder()
                .uuid(customer.getUuid())
                .fullName(customer.getFullName())
                .build();
    }
}
