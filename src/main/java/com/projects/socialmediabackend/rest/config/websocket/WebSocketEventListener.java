package com.projects.socialmediabackend.rest.config.websocket;

import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineOperation;
import com.projects.socialmediabackend.api.user.changestatusoffline.ChangeUserStatusOfflineRequest;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineOperation;
import com.projects.socialmediabackend.api.user.changestatusonline.ChangeUserStatusOnlineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    private final ChangeUserStatusOfflineOperation changeUserStatusOfflineOperation;
    private final ChangeUserStatusOnlineOperation changeUserStatusOnlineOperation;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        String username = headers.getUser().getName();
        changeUserStatusOnlineOperation.process(
                buildChangeOnlineStatusRequest(username)
        );
    }
    private ChangeUserStatusOnlineRequest buildChangeOnlineStatusRequest(String username){
        return ChangeUserStatusOnlineRequest.builder()
                .username(username)
                .build();
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        String username = headers.getUser().getName();
        changeUserStatusOfflineOperation.process(
                buildChangeOfflineStatusRequest(username)
        );
    }
    private ChangeUserStatusOfflineRequest buildChangeOfflineStatusRequest(String username){
        return ChangeUserStatusOfflineRequest.builder()
                .username(username)
                .build();
    }

}
