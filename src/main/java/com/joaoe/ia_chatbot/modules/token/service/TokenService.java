package com.joaoe.ia_chatbot.modules.token.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoe.ia_chatbot.modules.token.exception.TokenExpired;
import com.joaoe.ia_chatbot.modules.token.exception.TokenNotFound;
import com.joaoe.ia_chatbot.modules.token.model.Token;
import com.joaoe.ia_chatbot.modules.token.repository.TokenRepository;

@Service
public class TokenService {
    
    @Autowired
    TokenRepository tokenRepository;

    public Token generatedToken(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        
        String randomPart = Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        String timestampPart = String.valueOf(Instant.now().toEpochMilli());
        
        Token token = new Token();
        token.setDescricao("");
        token.setStatus("ACTIVATE");
        token.setValidade(Instant.now());
        token.setToken(randomPart + "" + hashTimeStamp(timestampPart));

        this.createToken(token);

        return token;
    }

    private static String hashTimeStamp(String timestamp){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(timestamp.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error generating token");
        }
    }

    private Token createToken(Token token){
        return tokenRepository.save(token);
    }

    public Token findTokenByToken(String token){
        Token rToken = tokenRepository.findByToken(token);

        if(rToken == null || rToken.getId() < 1){
            throw new TokenNotFound("Token not found");
        }

        return rToken;
    }

    public boolean isTokenValid(Token token){

        if(token.getValidade().isBefore(Instant.now())){
            throw new TokenExpired(String.format("Token expired: %s", token.getValidade()));
        }
        return true;
    }
}
