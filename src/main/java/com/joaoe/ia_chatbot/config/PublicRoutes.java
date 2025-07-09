package com.joaoe.ia_chatbot.config;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PublicRoutes {

    private final Set<Route> publicRoutes = new HashSet<>();

    public PublicRoutes() {
        publicRoutes.add(new Route(HttpMethod.POST.name(), "/users"));
        publicRoutes.add(new Route(HttpMethod.POST.name(), "/users/login"));
        publicRoutes.add(new Route(HttpMethod.POST.name(), "/v1/chats"));
        publicRoutes.add(new Route(HttpMethod.POST.name(), "/v1/tokens"));
    }

    public boolean isPublic(String method, String path) {
        return publicRoutes.contains(new Route(method, path));
    }

    public record Route(String method, String path) {}
}
