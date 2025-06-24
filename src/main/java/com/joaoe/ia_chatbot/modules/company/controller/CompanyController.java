package com.joaoe.ia_chatbot.modules.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoe.ia_chatbot.modules.company.dto.request.CreateCompanyRequest;
import com.joaoe.ia_chatbot.modules.company.dto.response.CreateCompanyResponse;
import com.joaoe.ia_chatbot.modules.company.mapper.CompanyMapper;
import com.joaoe.ia_chatbot.modules.company.model.Company;
import com.joaoe.ia_chatbot.modules.company.service.CompanyService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("companies")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyMapper companyMapper;

    @PostMapping
    public ResponseEntity<CreateCompanyResponse> createCompany(@RequestBody @Valid CreateCompanyRequest createCompanyRequest) {
        
        Company company = companyMapper.toCompany(createCompanyRequest);

        company = companyService.createCompany(company);

        CreateCompanyResponse companyResponse = companyMapper.toCreateCompanyResponse(company);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(companyResponse);
    }
    
}
