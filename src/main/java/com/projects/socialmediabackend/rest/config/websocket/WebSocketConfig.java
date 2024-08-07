package com.projects.socialmediabackend.rest.config.websocket;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
@EnableWebMvc
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final WebSocketHandler webSocketHandler;
    private final WebSocketHandlerInterceptor webSocketHandlerInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(webSocketHandler, "/api/v1/authenticated/websocket")
                .addInterceptors(webSocketHandlerInterceptor)
                .setAllowedOrigins("*");
    }


}

