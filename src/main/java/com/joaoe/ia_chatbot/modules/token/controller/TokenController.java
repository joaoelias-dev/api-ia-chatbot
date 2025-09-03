package com.joaoe.ia_chatbot.modules.token.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joaoe.ia_chatbot.modules.token.dto.request.UserGeneratedTokenDTO;
import com.joaoe.ia_chatbot.modules.token.dto.response.ResponseGeneratedTokenDTO;
import com.joaoe.ia_chatbot.modules.token.model.Token;
import com.joaoe.ia_chatbot.modules.token.service.TokenService;
import com.joaoe.ia_chatbot.modules.user.service.UserAccountService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/v1/tokens")
@RequiredArgsConstructor
public class TokenController {
    
    private final TokenService tokenService;
    private final UserAccountService userAccountService;

    @PostMapping
    public ResponseEntity<?> generatedToken(@RequestBody @Valid UserGeneratedTokenDTO user) {

        userAccountService.login(user.getUsername(), user.getPassword());

        Token token = tokenService.generatedToken();

        ResponseGeneratedTokenDTO generatedToken = ResponseGeneratedTokenDTO.builder()
            .description(token.getDescricao())
            .generetadToken(token.getToken())
            .status(token.getStatus())
            .experiedDate(token.getValidade())
            .build();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedToken);
    }
}
