package com.joaoe.ia_chatbot.modules.ollamaConversation.repository;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OllamaConfigRepository extends JpaRepository<OllamaConfig, Long> {
}
