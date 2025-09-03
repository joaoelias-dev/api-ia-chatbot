package com.joaoe.ia_chatbot.modules.ollamaConversation.service;

import com.joaoe.ia_chatbot.modules.ollamaConversation.exception.OllamaConversationInvalidData;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaOptions;
import com.joaoe.ia_chatbot.modules.ollamaConversation.repository.OllamaConfigRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OllamaConfigService {

    private final OllamaConfigRepository ollamaConfigRepository;
    private final OllamaOptionsService ollamaOptionsService;
    
    public OllamaConfig createOllamaConfig(OllamaConfig ollamaConfig){

        OllamaOptions ollamaOptions = ollamaOptionsService.createOllamaOptions(ollamaConfig.getOptions());

        ollamaConfig.setOptions(ollamaOptions);

        return ollamaConfigRepository.save(ollamaConfig);
    }

    public OllamaConfig findByUuid(UUID uuid){
        return ollamaConfigRepository.findByUuid(uuid).orElseThrow(() -> new OllamaConversationInvalidData("OllamaConfig not found"));
    }
}
