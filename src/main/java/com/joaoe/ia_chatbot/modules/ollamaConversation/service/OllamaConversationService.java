package com.joaoe.ia_chatbot.modules.ollamaConversation.service;

import com.joaoe.ia_chatbot.modules.customer.model.Customer;
import com.joaoe.ia_chatbot.modules.customer.service.CustomerService;
import com.joaoe.ia_chatbot.modules.ollamaConversation.model.OllamaConversation;
import com.joaoe.ia_chatbot.modules.ollamaConversation.repository.OllamaConversationRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class OllamaConversationService {

    @Autowired
    private OllamaConversationRepository ollamaConversationRepository;
    @Autowired
    private CustomerService customerService;

    public OllamaConversation createOllamaConversation(UUID customerUUID){

        Customer customer = customerService.findCustomerByUuid(customerUUID);

        OllamaConversation ollamaConversation = new OllamaConversation();

        ollamaConversation.setCustomer(customer);

        ollamaConversation = ollamaConversationRepository.saveAndFlush(ollamaConversation);

        return ollamaConversation;
    }

    public OllamaConversation findByUuidAndDeletedAtIsNull(UUID uuid) {
        return ollamaConversationRepository.findByUuidAndDeletedAtIsNull(uuid).orElseThrow(() -> new EntityNotFoundException("Conversation not found"));
    }
}
