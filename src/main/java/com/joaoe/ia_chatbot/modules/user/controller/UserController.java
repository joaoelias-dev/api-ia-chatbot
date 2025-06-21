package com.joaoe.ia_chatbot.modules.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoe.ia_chatbot.modules.user.dto.request.CreateUserDTORequest;
import com.joaoe.ia_chatbot.modules.user.dto.request.LoginDTO;
import com.joaoe.ia_chatbot.modules.user.dto.response.CreatedUserDTOResponse;
import com.joaoe.ia_chatbot.modules.user.model.UserAccount;
import com.joaoe.ia_chatbot.modules.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTORequest createUserDTORequest){

        userService.passwordsDoNotMatch(createUserDTORequest.getPassword1(), createUserDTORequest.getPassword2());

        UserAccount user = UserAccount.builder()
            .email(createUserDTORequest.getEmail())
            .password(createUserDTORequest.getPassword1())
            .username(createUserDTORequest.getUsername())
            .build();

        userService.createUser(user);

        CreatedUserDTOResponse createdUser = CreatedUserDTOResponse.builder()
            .email(user.getEmail())
            .username(user.getUsername())
            .uuid(user.getUuid())
            .status(user.getStatus())
            .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginDTO loginDTO) {
        userService.login(loginDTO.getUsername(), loginDTO.getPassword());
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("success");
    }
    
}
