package com.joaoe.ia_chatbot.modules.customer.service;

import com.joaoe.ia_chatbot.modules.customer.exception.CustomerInvalidData;
import com.joaoe.ia_chatbot.modules.customer.model.Customer;
import com.joaoe.ia_chatbot.modules.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Customer not find"));
    }
    public Customer findCustomerByUuid(UUID uuid){
        return customerRepository.findByUuid(uuid).orElseThrow(() -> new EntityNotFoundException("Customer not find"));
    }
    public Customer createCustomer(Customer customer){
        if(customer.getFullName().isBlank()){
            throw new CustomerInvalidData("Insert a valid name!");
        }
        customer = customerRepository.save(customer);
        customerRepository.flush();

        return customer;
    }
}
