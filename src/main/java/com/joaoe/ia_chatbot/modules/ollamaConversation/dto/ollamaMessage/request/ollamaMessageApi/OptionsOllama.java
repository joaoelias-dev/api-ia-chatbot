package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.request.ollamaMessageApi;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionsOllama {
    private Double temperature;
    private Integer top_k;
    private Double top_p;
    private Integer num_ctx;
    private Double repeat_penalty;
}
