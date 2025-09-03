package com.joaoe.ia_chatbot.modules.company.dto.response;

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
public class CreateCompanyAdressResponse {
    
    private UUID uuid;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String addressLine;
    private String district;
    private String number;
    private String complement;
}
