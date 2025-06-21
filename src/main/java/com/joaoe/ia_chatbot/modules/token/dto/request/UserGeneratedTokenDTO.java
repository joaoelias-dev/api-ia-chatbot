package com.joaoe.ia_chatbot.modules.token.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserGeneratedTokenDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Field 'username' is required")
    @Size(min = 3, message = "Username should not be less than 3")
    private String username;

    @NotBlank(message = "Field 'password1' is required")
    @Size(min = 6, message = "Password should not be less than 6")
    @Size(max = 255)
    private String password;
}
