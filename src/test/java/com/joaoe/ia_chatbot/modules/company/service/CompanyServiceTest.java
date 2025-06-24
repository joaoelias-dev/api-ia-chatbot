package com.joaoe.ia_chatbot.modules.company.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.joaoe.ia_chatbot.modules.company.model.Company;
import com.joaoe.ia_chatbot.modules.company.repository.CompanyRepository;

@SpringBootTest
public class CompanyServiceTest {

    @InjectMocks
    private CompanyService companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Test
    void testCreateCompany_success() {
        Company company = new Company();

        company.setBrandName("Teste");
        Mockito.when(companyRepository.save(Mockito.any()))
            .thenReturn(company);

        Company result = companyService.createCompany(company);

        assertAll("customer",
            () -> assertEquals("Teste", result.getBrandName())
        );
    }
}
