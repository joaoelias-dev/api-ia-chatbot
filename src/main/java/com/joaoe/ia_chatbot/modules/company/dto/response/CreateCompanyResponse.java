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
public class CreateCompanyResponse {
    
    private UUID uuid;
    private String brandName;
    private String legalName;
    private String taxId; // CNPJ, EIN, VAT, etc.
    private String email;
    private String website;  
    private String currency;
    private String timezone;

}
