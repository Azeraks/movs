package com.azera.movs.exercise_05.application.service;

import com.azera.movs.exercise_05.application.port.in.UserManagementPort;
import com.azera.movs.exercise_05.application.port.out.UserStoragePort;
import com.azera.movs.exercise_05.application.service.exceptions.UserNotFoundException;
import com.azera.movs.exercise_05.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserManagementPort {


    private final UserStoragePort storagePort;


    @Override
    public void register(User user) {

        //password hashing
        storagePort.broadcast(user, "added");
        storagePort.save(user);
    }

    @Override
    public boolean deleteUser(UUID uuid) {
        storagePort.broadcast(getUser(uuid), "delete");
        return storagePort.deleteUser(uuid);
    }

    @Override
    public User getUser(UUID uuid) {
        return storagePort.findById(uuid).orElseThrow(() -> new UserNotFoundException("User not found", uuid));
    }
}