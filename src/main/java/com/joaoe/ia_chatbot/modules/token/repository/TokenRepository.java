package com.joaoe.ia_chatbot.modules.token.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoe.ia_chatbot.modules.token.model.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long>{

    Token findByToken(String token);
}
