package com.joaoe.ia_chatbot.modules.ollamaConversation.repository;

import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaMessage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OllamaMessageRepository extends JpaRepository<OllamaMessage, Long> {

    @Query("SELECT messages FROM OllamaMessage messages WHERE messages.conversation.id = :conversationId ORDER BY messages.createdAt ASC")
    public List<OllamaMessage> returnMessagesFromConversation(@Param("conversationId") Long conversationId);

    @Query("SELECT messages FROM OllamaMessage messages WHERE messages.conversation.id = :conversationId AND messages.role = 'system' ORDER BY messages.createdAt ASC")
    public OllamaMessage returnSystemMessage(@Param("conversationId") Long conversationId);
}
