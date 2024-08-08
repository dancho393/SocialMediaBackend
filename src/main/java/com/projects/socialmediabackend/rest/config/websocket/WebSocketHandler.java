package com.projects.socialmediabackend.rest.config.websocket;



import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineOperation;
import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineRequest;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineOperation;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineRequest;
import com.projects.socialmediabackend.persistence.model.User;
import com.projects.socialmediabackend.persistence.model.enums.user.UserStatus;
import com.projects.socialmediabackend.persistence.repository.UserRepository;
import com.projects.socialmediabackend.rest.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final UserRepository userRepository;
    private final ChangeUserStatusOfflineOperation changeUserStatusOfflineOperation;
    private final ChangeUserStatusOnlineOperation changeUserStatusOnlineOperation;
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {


        String username = session.getAttributes().get("username").toString();
        System.out.println("Connection Established For User:"+ username);
        changeUserStatusOnlineOperation
                .process(
                        buildChangeUserOnlineRequest(username));


    }
    private ChangeUserStatusOnlineRequest buildChangeUserOnlineRequest(String username){
        return new ChangeUserStatusOnlineRequest(username);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        String username = session.getAttributes().get("username").toString();
        changeUserStatusOfflineOperation
                .process(
                        buildChangeUserOfflineRequest(username));
        System.out.println("Connection Unestablished For User: "+username);
    }
    private ChangeUserStatusOfflineRequest buildChangeUserOfflineRequest(String username){
        return new ChangeUserStatusOfflineRequest(username);
    }




}

