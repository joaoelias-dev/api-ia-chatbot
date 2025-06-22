package com.joaoe.ia_chatbot.modules.user.service;

import java.time.Instant;
import java.util.Optional;

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
import com.joaoe.ia_chatbot.modules.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    UserRepository userRepository;

    UserService(PasswordEncoder passwordEncoder) {
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

        return userRepository.save(user);
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
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
