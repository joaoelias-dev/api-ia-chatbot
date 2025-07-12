package com.joaoe.ia_chatbot.modules.ollamaConversation.service;

import com.joaoe.ia_chatbot.modules.ollamaConversation.mapper.OllamaMessaApiMapper;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaMessage;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import com.joaoe.ia_chatbot.modules.ollamaConversation.repository.OllamaMessageRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OllamaMessageService {

    private final String urlOllama = "http://localhost:11434/api/chat";

    private final OllamaMessageRepository ollamaMessageRepository;
    private final OllamaConversationService ollamaConversationService;
    private final OllamaMessaApiMapper ollamaMessaApiMapper;

    public OllamaMessage createMessage(UUID conversationUuid, OllamaMessage ollamaMessage, OllamaConfig ollamaConfig) {

        OllamaConversation ollamaConversation = ollamaConversationService.findByUuidAndDeletedAtIsNull(conversationUuid);

        ollamaMessage.setConversation(ollamaConversation);        

        return ollamaMessageRepository.save(ollamaMessage);
    }

    public String sendMessage(OllamaConversation conversation, OllamaMessage message, OllamaConfig ollamaConfig) {
    
        List<OllamaMessage> messages = this.returnMessagesFromConversation(conversation.getId());
        
        String json = buildMessageToOllama(conversation, messages, ollamaConfig);
        System.out.println(json);
        Mono<String> responseOllama = WebClient.create().post()
            .uri(urlOllama) // Altere para o endpoint correto
            //.header("Authorization", "Bearer SEU_TOKEN") // Se necessário
            .bodyValue(json)
            .retrieve()
            .onStatus(status -> status.is4xxClientError(), response ->
                response.bodyToMono(String.class)
                    .flatMap(body -> Mono.error(new RuntimeException("Erro 4xx: " + body)))
            )
            .onStatus(status -> status.is5xxServerError(), response ->
                response.bodyToMono(String.class)
                    .flatMap(body -> Mono.error(new RuntimeException("Erro 5xx: " + body)))
            )
        .bodyToMono(String.class);

        return responseOllama.block();
    }

    public List<OllamaMessage> returnMessagesFromConversation(Long conversationId){
        return ollamaMessageRepository.returnMessagesFromConversation(conversationId);
    }

    private String buildMessageToOllama(OllamaConversation conversation, List<OllamaMessage> messages, OllamaConfig ollamaConfig){
        String json = ollamaMessaApiMapper.buildMessageToOllama(conversation, messages , ollamaConfig);
        return json;
    }

    
}
