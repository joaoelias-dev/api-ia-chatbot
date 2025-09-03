package com.joaoe.ia_chatbot.modules.company.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class CreateCompanyRequest {

    @NotBlank(message = "Brand name should not be blank")
    private String brandName;
    private String legalName;
    private String taxId; // CNPJ, EIN, VAT, etc.
    private String email;
    private String website;  
    private String currency;
    private String timezone;
}
