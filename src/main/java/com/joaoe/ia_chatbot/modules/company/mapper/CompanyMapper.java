package com.joaoe.ia_chatbot.modules.company.mapper;

import org.springframework.stereotype.Component;

import com.joaoe.ia_chatbot.modules.company.dto.request.CreateCompanyRequest;
import com.joaoe.ia_chatbot.modules.company.dto.response.CreateCompanyResponse;
import com.joaoe.ia_chatbot.modules.company.model.Company;

@Component
public class CompanyMapper {
    
    public Company toCompany(CreateCompanyRequest createCompanyRequest){
        return Company.builder()
            .brandName(createCompanyRequest.getBrandName())
            .legalName(createCompanyRequest.getLegalName())
            .currency(createCompanyRequest.getCurrency())
            .email(createCompanyRequest.getEmail())
            .taxId(createCompanyRequest.getTaxId())
            .website(createCompanyRequest.getWebsite())
            .timezone(createCompanyRequest.getTimezone())
            .build();
    }

    public CreateCompanyResponse toCreateCompanyResponse(Company company){
        return CreateCompanyResponse.builder()
            .uuid(company.getUuid())
            .brandName(company.getBrandName())
            .legalName(company.getLegalName())
            .currency(company.getCurrency())
            .email(company.getEmail())
            .taxId(company.getTaxId())
            .website(company.getWebsite())
            .timezone(company.getTimezone())
            .build();
    }
}
