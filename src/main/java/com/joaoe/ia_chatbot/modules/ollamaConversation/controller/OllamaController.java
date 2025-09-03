package com.joaoe.ia_chatbot.modules.ollamaConversation.controller;

import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConfig.request.CreateOllamaConfigRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.mapper.OllamaConfigMapper;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import com.joaoe.ia_chatbot.modules.ollamaConversation.service.OllamaConfigService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ollama")
@RequiredArgsConstructor
public class OllamaController {

    private final OllamaConfigService ollamaConfigService;
    private final OllamaConfigMapper ollamaConfigMapper;
      
    @PostMapping
    public ResponseEntity<?> createOllamaConfig(@RequestBody @Valid CreateOllamaConfigRequest createOllamaConfigRequest){

        OllamaConfig ollamaConfig = ollamaConfigMapper.toOllamaConfig(createOllamaConfigRequest);

        ollamaConfigService.createOllamaConfig(ollamaConfig);

        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }
}
