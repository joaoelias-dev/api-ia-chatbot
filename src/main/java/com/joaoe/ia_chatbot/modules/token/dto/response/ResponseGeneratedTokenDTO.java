package com.joaoe.ia_chatbot.modules.token.dto.response;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ResponseGeneratedTokenDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String generetadToken;
    private Instant experiedDate;
    private String description;
    private String status;
}
