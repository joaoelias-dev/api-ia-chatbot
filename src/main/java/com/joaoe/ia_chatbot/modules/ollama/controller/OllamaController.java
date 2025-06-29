package com.joaoe.ia_chatbot.modules.ollama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoe.ia_chatbot.modules.ollama.dto.request.RequestMessageOllama;
import com.joaoe.ia_chatbot.modules.ollama.service.OllamaService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/v1/chats")
public class OllamaController {
    
    @Autowired
    OllamaService ollamaService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody @Valid RequestMessageOllama messageOllama){

        String response = "";
        try {
            System.out.println(messageOllama.getPrompt());
            ObjectMapper mapper = new ObjectMapper();

            String json = mapper.writeValueAsString(messageOllama);
            
            response = ollamaService.sendPrompt(json);
            System.out.println(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    
    
}
