package com.joaoe.ia_chatbot.modules.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank(message = "Invalid username")
    private String username;

    @NotBlank(message = "Invalid password")
    private String password;
}
