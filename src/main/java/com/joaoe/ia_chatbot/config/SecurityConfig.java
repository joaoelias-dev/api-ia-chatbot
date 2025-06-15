package com.joaoe.ia_chatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desativa CSRF para API REST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/users", "users/login", "/v1/chat").permitAll() // Libera POST no /users
                .anyRequest().authenticated() // Qualquer outro endpoint precisa de login
            );
            //.httpBasic(); // Autenticação Basic Auth (opcional: pode trocar para JWT depois)

        return http.build();
    }
}
