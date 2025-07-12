package com.joaoe.ia_chatbot.modules.ollamaConversation.mapper;

import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConfig.request.CreateOllamaConfigRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConfig.request.CreateOllamaOptionsRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OllamaConfigMapper {
    public OllamaConfig toOllamaConfig(CreateOllamaConfigRequest request) {
        if (request == null) return null;

        return OllamaConfig.builder()
                .model(request.getModel())
                .prompt(request.getPrompt())
                .suffix(request.getSuffix())
                .images(request.getImages())
                .think(request.isThink())
                .format(request.getFormat())
                .system(request.getSystem())
                .template(request.getTemplate())
                .options(toOptionsEntity(request.getOptions()))
                .stream(request.isStream())
                .raw(request.isRaw())
                .keep_alive(request.getKeep_alive())
                .build();
    }

    private OllamaOptions toOptionsEntity(CreateOllamaOptionsRequest optionsRequest) {
        if (optionsRequest == null) return null;

        return OllamaOptions.builder()
                .temperature(optionsRequest.getTemperature()) // substitua pelo getter correto
                .top_p(optionsRequest.getTop_p())       // substitua pelo getter correto
                .num_predict(optionsRequest.getNum_predict()) // substitua pelo getter correto
                .build();
    }
}
