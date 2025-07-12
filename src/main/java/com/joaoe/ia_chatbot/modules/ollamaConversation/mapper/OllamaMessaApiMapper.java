package com.joaoe.ia_chatbot.modules.ollamaConversation.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.ollamaMessageApi.MessagesOllama;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.ollamaMessageApi.OllamaMessageApiDTO;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.ollamaMessageApi.OptionsOllama;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaMessage;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaOptions;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OllamaMessaApiMapper {
    private final ObjectMapper objectMapper;

    /*
     * Return a JSON, ready to send to ollama IA
     */
    public String buildMessageToOllama(OllamaConversation conversation, List<OllamaMessage> messages, OllamaConfig ollamaConfig) {

        try {
            OllamaMessageApiDTO apiMessage = OllamaMessageApiDTO.builder()
                    .model(ollamaConfig.getModel())
                    .stream(false)
                    .raw(ollamaConfig.isRaw())
                    .keep_alive(ollamaConfig.getKeep_alive())
                    .options(mapOptions(ollamaConfig.getOptions()))
                    .messages(mapMessages(messages))
                    .build();

            return objectMapper.writeValueAsString(apiMessage);

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Occurs an error");
        }
    }

    private OptionsOllama mapOptions(OllamaOptions options) {
        if (options == null) return null;

        return OptionsOllama.builder()
            .temperature(options.getTemperature().doubleValue())
            .top_k(null)
            .top_p(options.getTop_p().doubleValue())
            .num_ctx(4096)
            .repeat_penalty(1.1)
            .build();
    }

    private List<MessagesOllama> mapMessages(List<OllamaMessage> messages) {
        if (messages == null) return List.of();

         return messages.stream().map(msg -> 
            MessagesOllama.builder()
                .role(msg.getRole().toLowerCase())
                .content(msg.getContent())
                .build()
        ).collect(Collectors.toList());
    }
}
