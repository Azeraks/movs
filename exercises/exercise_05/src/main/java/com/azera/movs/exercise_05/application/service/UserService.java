package com.azera.movs.exercise_05.application.service;

import com.azera.movs.exercise_05.adapter.controller.in.dto.BroadcastMessage;
import com.azera.movs.exercise_05.adapter.controller.in.websocket.Operation;
import com.azera.movs.exercise_05.adapter.controller.in.websocket.WebSocketController;
import com.azera.movs.exercise_05.application.port.in.UserManagementPort;
import com.azera.movs.exercise_05.application.port.out.UserStoragePort;
import com.azera.movs.exercise_05.application.service.exceptions.UserNotFoundException;
import com.azera.movs.exercise_05.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserManagementPort {

    private final UserStoragePort storagePort;
    private final WebSocketController webSocketController;

    @Override
    public void register(User user) {

        //password hashing
        boolean registerStatus = storagePort.save(user);

        if(registerStatus) {
            BroadcastMessage message = new BroadcastMessage(user.getId(), Operation.ADDED);
            webSocketController.broadcast(message);
        }
    }

    @Override
    public boolean deleteUser(UUID uuid) {
        boolean deletedStatus = storagePort.deleteUser(uuid);

        if(deletedStatus) {
            BroadcastMessage message = new BroadcastMessage(uuid, Operation.DELETED);
            webSocketController.broadcast(message);
        }
        return deletedStatus;
    }

    @Override
    public User getUser(UUID uuid) {
        return storagePort.findById(uuid).orElseThrow(() -> new UserNotFoundException("User not found", uuid));
    }
}