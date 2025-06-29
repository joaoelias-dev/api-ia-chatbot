package com.joaoe.ia_chatbot.modules.ollama.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.joaoe.ia_chatbot.modules.ollama.dto.request.RequestMessageOllama;
import com.joaoe.ia_chatbot.modules.ollama.service.OllamaService;

@ExtendWith(MockitoExtension.class)
public class OllamaControllerTest {

    @InjectMocks
    private OllamaController ollamaController;

    @Mock
    private OllamaService ollamaService;

    @Test
    public void return200SendMessage() {
        
        String respostaEsperada = "20";

        RequestMessageOllama request = RequestMessageOllama.builder()
                .model("llama2")
                .prompt("quanto é 10+10?")
                .stream(false)
                .build();

        Mockito.when(ollamaService.sendPrompt(Mockito.anyString()))
                .thenReturn(respostaEsperada);

        ResponseEntity<?> response = ollamaController.sendMessage(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(respostaEsperada, response.getBody());                
    }
}
