package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.ollamaMessageApi;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OllamaMessageApiDTO {
    
    private String model;
    //private String prompt;
    private String suffix;
    private String images;
    private boolean think;
    private String format;
    //private String system;
    private String template;
    private boolean stream;
    private boolean raw;
    private String keep_alive;
    private OptionsOllama options;
    private List<MessagesOllama> messages;
}
