package com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaMessage.response;

import java.math.BigInteger;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OllamaMessageResponse {
    private String model;
    private String created_at;
    private MessageResponse message;
    private String done_reason;
    private boolean done;
    private BigInteger total_duration;
    private BigInteger load_duration;
    private int prompt_eval_count;
    private BigInteger prompt_eval_duration;
    private int eval_count;
    private BigInteger eval_duration;
}