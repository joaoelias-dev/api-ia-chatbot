package com.joaoe.ia_chatbot.modules.company.mapper;

import org.springframework.stereotype.Component;

import com.joaoe.ia_chatbot.modules.company.dto.request.CreateCompanyAdressRequest;
import com.joaoe.ia_chatbot.modules.company.dto.response.CreateCompanyAdressResponse;
import com.joaoe.ia_chatbot.modules.company.model.Company;
import com.joaoe.ia_chatbot.modules.company.model.CompanyAdress;

@Component
public class CompanyAdressMapper {

    public CompanyAdress toCompanyAdress(Company company,CreateCompanyAdressRequest createCompanyAdressRequest){
        return CompanyAdress.builder()
            .addressLine(createCompanyAdressRequest.getAddressLine())
            .city(createCompanyAdressRequest.getCity())
            .company(company)
            .complement(createCompanyAdressRequest.getComplement())
            .country(createCompanyAdressRequest.getCountry())
            .district(createCompanyAdressRequest.getDistrict())
            .number(createCompanyAdressRequest.getNumber())
            .state(createCompanyAdressRequest.getState())
            .zipCode(createCompanyAdressRequest.getZipCode())
            .build();
    }
    
    public CreateCompanyAdressResponse toCompanyAdressResponse(CompanyAdress companyAdress){
        return CreateCompanyAdressResponse.builder()
            .uuid(companyAdress.getUuid())
            .addressLine(companyAdress.getAddressLine())
            .city(companyAdress.getCity())
            .complement(companyAdress.getComplement())
            .country(companyAdress.getCountry())
            .district(companyAdress.getDistrict())
            .number(companyAdress.getNumber())
            .state(companyAdress.getState())
            .zipCode(companyAdress.getZipCode())
            .build();
    }
}
