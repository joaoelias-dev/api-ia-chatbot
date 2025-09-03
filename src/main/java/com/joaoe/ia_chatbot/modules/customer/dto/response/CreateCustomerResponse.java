package com.joaoe.ia_chatbot.modules.customer.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
public class CreateCustomerResponse {

    private UUID uuid;
    private String fullName;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deleted;

}
