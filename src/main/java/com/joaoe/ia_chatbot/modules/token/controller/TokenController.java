package com.joaoe.ia_chatbot.modules.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joaoe.ia_chatbot.modules.token.dto.request.UserGeneratedTokenDTO;
import com.joaoe.ia_chatbot.modules.token.dto.response.ResponseGeneratedTokenDTO;
import com.joaoe.ia_chatbot.modules.token.model.Token;
import com.joaoe.ia_chatbot.modules.token.service.TokenService;
import com.joaoe.ia_chatbot.modules.user.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@Controller
@RequestMapping("/v1/tokens")
public class TokenController {
    
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> generatedToken(@RequestBody @Valid UserGeneratedTokenDTO user) {

        userService.login(user.getUsername(), user.getPassword());

        Token token = tokenService.generatedToken();

        ResponseGeneratedTokenDTO generatedToken = ResponseGeneratedTokenDTO.builder()
            .description(token.getDescricao())
            .generetadToken(token.getToken())
            .status(token.getStatus())
            .experiedDate(token.getValidade())
            .build();
        
        return ResponseEntity.status(HttpStatus.CREATED).body(generatedToken);
    }

    @GetMapping
    public ResponseEntity<?> testToken() {
        System.out.println("teste");
        return ResponseEntity.status(HttpStatus.OK).body("Teste");
    }
    
    @PutMapping
    public ResponseEntity<?> putMethodName() {
        
        System.out.println("aaaaaa");

        return ResponseEntity.status(HttpStatus.OK).body("Teste put");
    }
}
