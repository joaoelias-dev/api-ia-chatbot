package com.joaoe.ia_chatbot.modules.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoe.ia_chatbot.modules.company.model.Company;
import java.util.UUID;


public interface CompanyRepository extends JpaRepository<Company, Long> {
    
    public Company findByUuid(UUID uuid);
}
