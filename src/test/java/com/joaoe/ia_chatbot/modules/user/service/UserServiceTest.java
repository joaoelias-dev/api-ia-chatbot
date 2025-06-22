package com.joaoe.ia_chatbot.modules.user.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.joaoe.ia_chatbot.modules.user.model.UserAccount;
import com.joaoe.ia_chatbot.modules.user.repository.UserRepository;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockitoBean
    private UserRepository userRepository;

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @Test
    void testCreateUser_Success() {
        UserAccount user = UserAccount.builder()
            .username("elias")
            .password("123456")
            .email("joao@gmail.com")
            .build();

        Mockito.when(userRepository.existsByUsername("elias")).thenReturn(false);
        Mockito.when(userRepository.existsByEmail("joao@gmail.com")).thenReturn(false);
        Mockito.when(passwordEncoder.encode("123456")).thenReturn("encryptedPassword");

        Mockito.when(userRepository.save(Mockito.any(UserAccount.class)))
            .thenAnswer(invocation -> {
                UserAccount saved = invocation.getArgument(0);
                saved.setId(1L);
                saved.setUuid(UUID.randomUUID());
                saved.setCreateAt(Instant.now());
                return saved;
            });

        UserAccount created = userService.createUser(user);
        
        assertNotNull(created.getUuid());
        assertNotNull(created.getId());
        assertEquals("elias", created.getUsername());
        assertEquals("joao@gmail.com", created.getEmail());
        assertEquals("ACTIVE", created.getStatus());
        assertEquals("encryptedPassword", created.getPassword());
        assertNotNull(created.getCreateAt());
    }

    // @Test
    // void testExistsByEmail() {

    // }

    // @Test
    // void testExistsByUsername() {

    // }

    // @Test
    // void testFindByUsername() {

    // }

    // @Test
    // void testLogin() {

    // }

    // @Test
    // void testPasswordsDoNotMatch() {

    // }
}
