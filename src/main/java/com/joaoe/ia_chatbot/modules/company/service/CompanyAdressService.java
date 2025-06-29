package com.joaoe.ia_chatbot.modules.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoe.ia_chatbot.modules.company.model.CompanyAdress;
import com.joaoe.ia_chatbot.modules.company.repository.CompanyAdressRepository;

@Service
public class CompanyAdressService {
    
    @Autowired
    private CompanyAdressRepository companyAdressRepository;

    public CompanyAdress createCompanyAdress(CompanyAdress companyAdress){
        
        
        companyAdress = companyAdressRepository.save(companyAdress);

        return companyAdress;
    }
}
