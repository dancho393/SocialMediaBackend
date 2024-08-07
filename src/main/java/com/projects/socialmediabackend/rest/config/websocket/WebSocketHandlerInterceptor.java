package com.projects.socialmediabackend.rest.config.websocket;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class WebSocketHandlerInterceptor implements HandshakeInterceptor {


    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String username = request.getHeaders().getFirst("username");
        if (username == null) {
            username = request.getURI().getQuery().split("=")[1];
        }

        if (username != null) {
            attributes.put("username", username);
        } else {
            throw new IllegalArgumentException("Username must be provided");
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
