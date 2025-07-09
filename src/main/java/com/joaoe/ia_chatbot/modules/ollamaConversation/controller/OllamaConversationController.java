package com.joaoe.ia_chatbot.modules.ollamaConversation.controller;

import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.request.createConversationRequest.CreateConversationRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.CreateMessageRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConversation.response.createOllamaConversation.CreateOllamaConversationResponse;
import com.joaoe.ia_chatbot.modules.ollamaConversation.mapper.OllamaConversationMapper;
import com.joaoe.ia_chatbot.modules.ollamaConversation.mapper.OllamaMessageMapper;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaMessage;
import com.joaoe.ia_chatbot.modules.ollamaConversation.service.OllamaConversationService;
import com.joaoe.ia_chatbot.modules.ollamaConversation.service.OllamaMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("chats")
@RestController
@RequiredArgsConstructor
public class OllamaConversationController {

    private final OllamaConversationService ollamaConversationService;
    private final OllamaMessageService ollamaMessageService;
    private final OllamaConversationMapper ollamaConversationMapper;

    @PostMapping
    public ResponseEntity<CreateOllamaConversationResponse> createConversation(@RequestBody @Valid CreateConversationRequest createConversationRequest){

        OllamaConversation ollamaConversation = ollamaConversationService.createOllamaConversation(createConversationRequest.getCustomerUuid());

        CreateOllamaConversationResponse  createOllamaConversationResponse = ollamaConversationMapper.createOllamaConversationResponse(ollamaConversation);

        return ResponseEntity.status(HttpStatus.CREATED).body(createOllamaConversationResponse);
    }

    @PostMapping("{conversation-uuid}")
    public ResponseEntity<?> sendMessage(@PathVariable("conversation-uuid") @Valid UUID conversationUuid,
                                         @RequestBody @Valid CreateMessageRequest messageRequest){

        OllamaMessage ollamaMessage = OllamaMessageMapper.toOllamaMessage(messageRequest);

        ollamaMessageService.createMessage(conversationUuid, ollamaMessage);

        return ResponseEntity.status(HttpStatus.CREATED).body("New conversation");
    }
}
