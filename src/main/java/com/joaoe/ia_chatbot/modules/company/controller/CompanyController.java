package com.joaoe.ia_chatbot.modules.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoe.ia_chatbot.modules.company.dto.request.CreateCompanyAdressRequest;
import com.joaoe.ia_chatbot.modules.company.dto.request.CreateCompanyRequest;
import com.joaoe.ia_chatbot.modules.company.dto.response.CreateCompanyAdressResponse;
import com.joaoe.ia_chatbot.modules.company.dto.response.CreateCompanyResponse;
import com.joaoe.ia_chatbot.modules.company.mapper.CompanyAdressMapper;
import com.joaoe.ia_chatbot.modules.company.mapper.CompanyMapper;
import com.joaoe.ia_chatbot.modules.company.model.Company;
import com.joaoe.ia_chatbot.modules.company.model.CompanyAdress;
import com.joaoe.ia_chatbot.modules.company.service.CompanyAdressService;
import com.joaoe.ia_chatbot.modules.company.service.CompanyService;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("companies")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyAdressMapper companyAdressMapper;

    @Autowired
    private CompanyAdressService companyAdressService;

    @PostMapping
    public ResponseEntity<CreateCompanyResponse> createCompany(@RequestBody @Valid CreateCompanyRequest createCompanyRequest) {
        
        Company company = companyMapper.toCompany(createCompanyRequest);

        company = companyService.createCompany(company);

        CreateCompanyResponse companyResponse = companyMapper.toCreateCompanyResponse(company);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(companyResponse);
    }
    
    @PostMapping("addresses/{companyuuid}")
    public ResponseEntity<CreateCompanyAdressResponse> createCompanyAdress(@PathVariable(name = "companyuuid") UUID companyuuid, @RequestBody @Valid CreateCompanyAdressRequest createCompanyAdressRequest) {
        
        Company company = companyService.findCompanyByUUID(companyuuid);

        CompanyAdress companyAdress = companyAdressService.createCompanyAdress(companyAdressMapper.toCompanyAdress(company, createCompanyAdressRequest));

        companyAdress = companyAdressService.createCompanyAdress(companyAdress);
        
        CreateCompanyAdressResponse createCompanyAdressResponse = companyAdressMapper.toCompanyAdressResponse(companyAdress);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(createCompanyAdressResponse);
    }
    
}
