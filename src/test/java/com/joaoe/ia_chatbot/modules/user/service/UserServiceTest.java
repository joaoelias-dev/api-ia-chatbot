package com.joaoe.ia_chatbot.modules.user.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.joaoe.ia_chatbot.modules.user.model.User;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Mock
    UserService userService;

    @Test
    void testCreateUser() {
        User user = new User();
        
        System.out.println(user);
    }

    @Test
    void testExistsByEmail() {

    }

    @Test
    void testExistsByUsername() {

    }

    @Test
    void testFindByUsername() {

    }

    @Test
    void testLogin() {

    }

    @Test
    void testPasswordsDoNotMatch() {

    }
}
