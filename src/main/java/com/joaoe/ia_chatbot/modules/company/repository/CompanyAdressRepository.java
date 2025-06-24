package com.joaoe.ia_chatbot.modules.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoe.ia_chatbot.modules.company.model.CompanyAdress;

public interface CompanyAdressRepository extends JpaRepository<CompanyAdress, Long> {
    
}
