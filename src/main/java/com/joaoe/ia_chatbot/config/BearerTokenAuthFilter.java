package com.joaoe.ia_chatbot.config;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.joaoe.ia_chatbot.modules.token.model.Token;
import com.joaoe.ia_chatbot.modules.token.service.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BearerTokenAuthFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid token");
            return;
        }

        String token = authHeader.substring(7);

        Token rtoken = tokenService.findTokenByToken(token);
        
        tokenService.isTokenValid(rtoken);

        UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            rtoken.getToken(), // Você pode passar o ID, o email, ou até o próprio objeto UserAccount
                            null,
                            Collections.emptyList() // Sem roles no momento. Pode configurar roles futuramente se quiser.
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);


        filterChain.doFilter(request, response);
    }
    
}
