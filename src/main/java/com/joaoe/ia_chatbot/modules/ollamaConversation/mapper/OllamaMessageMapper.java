package com.joaoe.ia_chatbot.modules.ollamaConversation.mapper;

import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.CreateMessageRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaMessage;
import org.springframework.stereotype.Component;

@Component
public class OllamaMessageMapper {

    public static OllamaMessage toOllamaMessage(CreateMessageRequest createMessageRequest){
        return OllamaMessage.builder()
                .role(createMessageRequest.getRole())
                .content(createMessageRequest.getContent())
                .build();
    }



}
