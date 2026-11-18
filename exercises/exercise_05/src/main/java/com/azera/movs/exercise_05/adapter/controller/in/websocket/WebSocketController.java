package com.azera.movs.exercise_05.adapter.controller.in.websocket;

import com.azera.movs.exercise_05.adapter.controller.in.dto.BroadcastMessage;
import com.azera.movs.exercise_05.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketController extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper;

    public WebSocketController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.put(session.getId(), session);
        System.out.println("Client: " + session.getId());
    }

    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String m = objectMapper.readValue(message.getPayload(), String.class);
        System.out.println(m);
    }

    public void broadcast(BroadcastMessage message) {

        for(WebSocketSession ws : sessions.values()) {
            if(ws.isOpen()) {
                try {
                    String jsonFormat = objectMapper.writeValueAsString(message);
                    TextMessage m = new TextMessage(jsonFormat);
                    ws.sendMessage(m);
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session.getId());
    }
}
