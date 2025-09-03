package com.joaoe.ia_chatbot.modules.appointment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateAppointmentRequest {

    @NotBlank(message = "Title should not be blank")
    private String title;

    @NotNull(message = "Starts should not be null")
    private Instant starts;

    @NotNull(message = "Starts should not be null")
    private Instant ends;

    @NotBlank(message = "Status should not be blank")
    private String status;

    private String description;

    @NotNull
    private UUID userAccount;
}
