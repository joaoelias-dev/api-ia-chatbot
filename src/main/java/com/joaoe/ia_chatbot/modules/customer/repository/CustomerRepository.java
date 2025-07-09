package com.joaoe.ia_chatbot.modules.customer.repository;

import com.joaoe.ia_chatbot.modules.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.uuid = :uuid")
    Optional<Customer> findByUuid(@Param("uuid") UUID uuid);
}
