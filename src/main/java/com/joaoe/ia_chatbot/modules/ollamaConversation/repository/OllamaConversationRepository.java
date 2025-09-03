package com.joaoe.ia_chatbot.modules.ollamaConversation.repository;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OllamaConversationRepository extends JpaRepository<OllamaConversation, Long> {

    boolean existsByUuid(UUID uuid);

    // Find by uuid
    Optional<OllamaConversation> findByUuid(UUID uuid);

    // Search by UUID and verify if was deleted
    Optional<OllamaConversation> findByUuidAndDeletedAtIsNull(UUID uuid);

}
