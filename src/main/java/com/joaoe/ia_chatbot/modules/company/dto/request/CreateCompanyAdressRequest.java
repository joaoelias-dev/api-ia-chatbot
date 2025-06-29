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
public class CreateCompanyAdressRequest {
    
    private String country;
    private String state;

    @NotBlank(message = "Name of city can not be blank!")
    private String city;
    private String zipCode;
    private String addressLine;
    private String district;
    private String number;
    private String complement;

}
