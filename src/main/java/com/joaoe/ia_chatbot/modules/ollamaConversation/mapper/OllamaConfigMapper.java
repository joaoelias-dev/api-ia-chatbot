package com.joaoe.ia_chatbot.modules.ollamaConversation.mapper;

import com.joaoe.ia_chatbot.modules.ollamaConversation.dto.ollamaConfig.request.CreateOllamaConfigRequest;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaConfig;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.Ollama.OllamaOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

    private OllamaOptions toOptionsEntity(CreateOllamaConfigRequest optionsRequest) {
        if (optionsRequest == null) return null;

        return OllamaOptions.builder()
                .temperature(parseBigDecimal(optionsRequest.getFormat())) // substitua pelo getter correto
                .top_p(parseBigDecimal(optionsRequest.getSuffix()))       // substitua pelo getter correto
                .num_predict(parseInteger(optionsRequest.getTemplate())) // substitua pelo getter correto
                .build();
    }

    private BigDecimal parseBigDecimal(String value) {
        try {
            return value != null ? new BigDecimal(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseInteger(String value) {
        try {
            return value != null ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
