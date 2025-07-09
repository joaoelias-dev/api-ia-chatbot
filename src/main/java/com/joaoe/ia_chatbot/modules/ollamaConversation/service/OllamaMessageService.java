package com.joaoe.ia_chatbot.modules.ollamaConversation.service;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaMessage;
import com.joaoe.ia_chatbot.modules.ollamaConversation.repository.OllamaMessageRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OllamaMessageService {

    private final OllamaMessageRepository ollamaMessageRepository;
    private final OllamaConversationService ollamaConversationService;

    public OllamaMessageService(OllamaMessageRepository ollamaMessageRepository,
                                OllamaConversationService ollamaConversationService) {
        this.ollamaMessageRepository = ollamaMessageRepository;
        this.ollamaConversationService = ollamaConversationService;
    }
    public OllamaMessage createMessage(UUID conversationUuid, OllamaMessage ollamaMessage){

        OllamaConversation ollamaConversation = ollamaConversationService.findByUuidAndDeletedAtIsNull(conversationUuid);

        ollamaMessage.setConversation(ollamaConversation);

        return ollamaMessageRepository.save(ollamaMessage);
    }

}
