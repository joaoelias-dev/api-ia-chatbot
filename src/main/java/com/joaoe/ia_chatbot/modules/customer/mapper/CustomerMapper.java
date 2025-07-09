package com.joaoe.ia_chatbot.modules.customer.mapper;

import com.joaoe.ia_chatbot.modules.customer.dto.request.CreateCustomerRequest;
import com.joaoe.ia_chatbot.modules.customer.dto.response.CreateCustomerResponse;
import com.joaoe.ia_chatbot.modules.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public static Customer toCustomer(CreateCustomerRequest createCustomerRequest){
        return Customer.builder()
                .fullName(createCustomerRequest.getFullName())
                .build();
    }

    public static CreateCustomerResponse toCreateCustomerResponse(Customer customer){
        return CreateCustomerResponse.builder()
                .uuid(customer.getUuid())
                .fullName(customer.getFullName())
                .createdAt(customer.getCreatedAt())
                .updatedAt(customer.getUpdatedAt())
                .deleted(customer.getDeletedAt())
                .build();
    }
}
