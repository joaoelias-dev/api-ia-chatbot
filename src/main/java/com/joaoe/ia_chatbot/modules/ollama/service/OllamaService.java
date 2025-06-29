package com.joaoe.ia_chatbot.modules.ollama.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OllamaService {
    
    private final WebClient webClient;

    public OllamaService() {
        this.webClient = WebClient.builder()
            .baseUrl("http://localhost:11434")
            .build();
    }

    public String sendPrompt(String prompt) {
        String resposta = "";
        System.out.println(prompt);
        try {
            resposta =  webClient.post()
                .uri("/api/chat")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(prompt)
                .retrieve()
                .bodyToMono(String.class)
                .block();    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resposta;
    }
}
