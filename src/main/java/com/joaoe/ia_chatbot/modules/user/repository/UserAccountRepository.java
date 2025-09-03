package com.joaoe.ia_chatbot.modules.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaoe.ia_chatbot.modules.user.model.UserAccount;


@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{

    Optional<UserAccount> findByUsername(String username);

    Optional<UserAccount> findByUuid(UUID uuid);
    
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
