package com.joaoe.ia_chatbot.modules.user.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.joaoe.ia_chatbot.modules.user.repository.UserAccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoe.ia_chatbot.modules.user.exception.EmailAlreadyExistsException;
import com.joaoe.ia_chatbot.modules.user.exception.PasswordDoNotMatch;
import com.joaoe.ia_chatbot.modules.user.exception.UsernameAlreadyExistsException;
import com.joaoe.ia_chatbot.modules.user.exception.UsernameNotFound;
import com.joaoe.ia_chatbot.modules.user.model.UserAccount;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserAccountService {

    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserAccountRepository userAccountRepository;

    UserAccountService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public UserAccount createUser(UserAccount user) {

        if(existsByUsername(user.getUsername())){
            throw new UsernameAlreadyExistsException(user.getUsername());
        }

        if(existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        user.setStatus("ACTIVE");
        user.setCreateAt(Instant.now());

        // Crypt the pass
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userAccountRepository.save(user);
    }

    public UserAccount login(String username, String pass){
        UserAccount user = findByUsername(username).orElseThrow(
            () -> new UsernameNotFound("UserAccount not found")
        );

        if(!passwordEncoder.matches(pass, user.getPassword())){
            throw new BadCredentialsException("Invalid credentials");
        }

        return user;
    }

    // Verify pass1 to pass2 to create a new user
    public boolean passwordsDoNotMatch(String pass1, String pass2){
        if(!pass1.equals(pass2)){
            throw new PasswordDoNotMatch("Passwords do not match");
        }
        return true;
    }

    public Optional<UserAccount> findByUsername(String username){
        return userAccountRepository.findByUsername(username);
    }

    public UserAccount findByUUID(UUID uuid){
        return userAccountRepository.findByUuid(uuid)
                .orElseThrow(() -> new EntityNotFoundException("User account not found :" + uuid));
    }

    public boolean existsByUsername(String username){
        return userAccountRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userAccountRepository.existsByEmail(email);
    }
}
