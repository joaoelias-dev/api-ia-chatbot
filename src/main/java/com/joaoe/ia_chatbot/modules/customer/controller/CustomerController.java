package com.joaoe.ia_chatbot.modules.customer.controller;

import com.joaoe.ia_chatbot.modules.customer.dto.request.CreateCustomerRequest;
import com.joaoe.ia_chatbot.modules.customer.dto.response.CreateCustomerResponse;
import com.joaoe.ia_chatbot.modules.customer.mapper.CustomerMapper;
import com.joaoe.ia_chatbot.modules.customer.model.Customer;
import com.joaoe.ia_chatbot.modules.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){

        Customer customer = CustomerMapper.toCustomer(createCustomerRequest);

        customer = customerService.createCustomer(customer);

        CreateCustomerResponse createCustomerResponse = CustomerMapper.toCreateCustomerResponse(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerResponse);
    }

}
