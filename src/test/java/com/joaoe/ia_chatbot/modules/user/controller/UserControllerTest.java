package com.joaoe.ia_chatbot.modules.user.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaoe.ia_chatbot.modules.user.dto.response.CreatedUserDTOResponse;
import com.joaoe.ia_chatbot.modules.user.model.UserAccount;
import com.joaoe.ia_chatbot.modules.user.service.UserService;

@WebMvcTest(UserController.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    void testCreateUser_ReturnSuccess() throws Exception {
        
        String requestBody = """
            {
                "email": "joao@gmail.com",
                "password1": "1234567",
                "password2": "1234567",
                "username": "joao"
            }
            """;
        
        CreatedUserDTOResponse response = CreatedUserDTOResponse.builder()
            .email("joao@gmail.com")
            .username("joao")
            .uuid(UUID.randomUUID())
            .status("ACTIVE")
            .build();


        Mockito.when((userService).passwordsDoNotMatch("123", "123")).thenReturn(false);

        Mockito.when(userService.createUser(Mockito.any(UserAccount.class)))
            .thenAnswer(invocation -> {
                UserAccount user = invocation.getArgument(0);
                user.setUuid(response.getUuid());
                user.setStatus(response.getStatus());
                return user;
            });
        
        mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("joao@gmail.com"))
                .andExpect(jsonPath("$.username").value("joao"))
                .andExpect(jsonPath("$.uuid").value(response.getUuid().toString()))
                .andExpect(jsonPath("$.status").value("ACTIVE"));
    }

    @Test
    void testCreateUser_InvalidFields_ReturnBadRequest() throws Exception {
        String requestBody = """
        {
            "email": "",
            "password1": "123",
            "password2": "123",
            "username": ""
        }
        """;

    MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/users")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
                .andExpect(status().isBadRequest())
                .andReturn();

        String responseBody = response.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseBody);

        JsonNode errorsNode = jsonNode.get("errors");

        List<String> errors = new ArrayList<>();
        if(errorsNode.isArray()) {
            errorsNode.forEach(e -> errors.add(e.asText()));
        }
        
        assertTrue(errors.contains("Field 'username' is required"));
        assertTrue(errors.contains("Password should not be less than 6"));
        assertTrue(errors.contains("Field 'email' is required"));
    }

    @Test
    void testLogin_ReturnSuccess() throws Exception {
        String requestBody = """
            {
                "username": "joao",
                "password": "1234567"   
            }
            """;
        
        Mockito.when(userService.login("joao", "1234567")).thenReturn(new UserAccount());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
                .andExpect(status().isAccepted())
                .andReturn();
    }

    @Test
    void testLogin_BadRequest() throws Exception {
        String requestBody = """
            {
                "username": "",
                "password": ""   
            }
            """;
        
        Mockito.when(userService.login("joao", "1234567")).thenReturn(new UserAccount());

        mockMvc.perform(MockMvcRequestBuilders.post("/users/login")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
                .andExpect(status().isBadRequest())
                .andReturn();

    }
}
