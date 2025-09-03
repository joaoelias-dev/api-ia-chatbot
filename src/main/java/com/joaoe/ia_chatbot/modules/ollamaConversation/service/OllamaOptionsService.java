package com.joaoe.ia_chatbot.modules.ollamaConversation.service;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaOptions;
import com.joaoe.ia_chatbot.modules.ollamaConversation.repository.OllamaOptionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OllamaOptionsService {

    private final OllamaOptionsRepository ollamaOptionsRepository;

    public OllamaOptions createOllamaOptions(OllamaOptions ollamaOptions){
        return ollamaOptionsRepository.save(ollamaOptions);
    }
}
