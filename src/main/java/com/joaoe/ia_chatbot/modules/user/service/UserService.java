package com.joaoe.ia_chatbot.modules.user.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaoe.ia_chatbot.modules.user.exception.EmailAlreadyExistsException;
import com.joaoe.ia_chatbot.modules.user.exception.PasswordDoNotMacth;
import com.joaoe.ia_chatbot.modules.user.exception.UsernameAlreadyExistsException;
import com.joaoe.ia_chatbot.modules.user.exception.UsernameNotFound;
import com.joaoe.ia_chatbot.modules.user.model.User;
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

    public User createUser(User user) {

        if(existsByUsername(user.getUsername())){
            throw new UsernameAlreadyExistsException(user.getUsername());
        }

        if(existsByEmail(user.getEmail())){
            throw new EmailAlreadyExistsException(user.getEmail());
        }
        user.setStatus("ACTIVE");
        user.setCreateAt(LocalDateTime.now());

        // Crypt the pass
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public User login(String username, String pass){
        User user = findByUsername(username).orElseThrow(
            () -> new UsernameNotFound("User not found")
        );

        if(!passwordEncoder.matches(pass, user.getPassword())){
            throw new BadCredentialsException("Invalid credentials");
        }

        return user;
    }

    public boolean passwordsDoNotMatch(String pass1, String pass2){
        if(!pass1.equals(pass2)){
            throw new PasswordDoNotMacth("Passwords do not match");
        }
        return true;
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
