package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConfig.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOllamaConfigRequest {

    private String model;
    private String prompt;
    private String suffix;
    private String images;
    private boolean think;
    private String format;
    private String system;
    private String template;
    private CreateOllamaConfigRequest options;
    private boolean stream;
    private boolean raw;
    private String keep_alive;
}
