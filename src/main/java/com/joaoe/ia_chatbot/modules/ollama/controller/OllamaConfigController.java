package com.joaoe.ia_chatbot.modules.ollama.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoe.ia_chatbot.modules.ollama.dto.request.RequestOllamaConfig;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/ollama")
public class OllamaConfigController {
    
    @PostMapping
    public ResponseEntity<?> createOllamaConfig(@RequestBody @Valid  RequestOllamaConfig requestOllamaConfig) {
        
        
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
    
}
