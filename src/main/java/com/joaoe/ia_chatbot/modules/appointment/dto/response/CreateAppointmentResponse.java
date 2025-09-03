package com.joaoe.ia_chatbot.modules.appointment.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAppointmentResponse {

    private UUID uuid;
    private String title;
    private Instant starts;
    private Instant ends;
    private String status;
    private String description;
    private String userAccount;
}
