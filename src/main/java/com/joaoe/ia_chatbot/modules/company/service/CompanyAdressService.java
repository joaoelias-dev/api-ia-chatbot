package com.joaoe.ia_chatbot.modules.company.service;

import org.springframework.stereotype.Service;

import com.joaoe.ia_chatbot.modules.company.model.CompanyAdress;
import com.joaoe.ia_chatbot.modules.company.repository.CompanyAdressRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompanyAdressService {
    
    private final CompanyAdressRepository companyAdressRepository;

    public CompanyAdress createCompanyAdress(CompanyAdress companyAdress){
        
        
        companyAdress = companyAdressRepository.save(companyAdress);

        return companyAdress;
    }
}
