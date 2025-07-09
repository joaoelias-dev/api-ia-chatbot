package com.joaoe.ia_chatbot.modules.company.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.joaoe.ia_chatbot.modules.company.model.Company;
import com.joaoe.ia_chatbot.modules.company.repository.CompanyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyService {
    
    private final CompanyRepository companyRepository;

    public Company createCompany(Company company){
        return companyRepository.save(company);
    }

    public Company findCompanyByUUID(UUID uuid){
        return companyRepository.findByUuid(uuid);
    }
}
