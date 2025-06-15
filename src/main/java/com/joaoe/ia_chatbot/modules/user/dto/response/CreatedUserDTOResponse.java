package com.joaoe.ia_chatbot.modules.user.dto.response;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatedUserDTOResponse implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private UUID uuid;
    private String email;
    private String username;
    private String status;

}
