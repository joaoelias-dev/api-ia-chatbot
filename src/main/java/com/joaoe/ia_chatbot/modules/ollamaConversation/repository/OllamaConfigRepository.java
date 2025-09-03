package com.joaoe.ia_chatbot.modules.ollamaConversation.repository;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OllamaConfigRepository extends JpaRepository<OllamaConfig, Long> {

    @Query("SELECT ollamaConfig FROM OllamaConfig ollamaConfig "
        + " WHERE ollamaConfig.uuid = :uuid ")
    public Optional<OllamaConfig> findByUuid(UUID uuid);
}
