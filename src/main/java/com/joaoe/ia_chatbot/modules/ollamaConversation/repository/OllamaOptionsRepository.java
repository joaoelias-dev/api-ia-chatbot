package com.joaoe.ia_chatbot.modules.ollamaConversation.repository;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OllamaOptionsRepository extends JpaRepository<OllamaOptions, Long> {
}
