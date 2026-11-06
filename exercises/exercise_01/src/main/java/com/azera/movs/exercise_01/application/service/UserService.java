package com.azera.movs.exercise_01.application.service;

import com.azera.movs.exercise_01.adapter.controller.out.UserStorageAdapter;
import com.azera.movs.exercise_01.application.port.in.UserManagementPort;
import com.azera.movs.exercise_01.application.port.out.UserStoragePort;
import com.azera.movs.exercise_01.application.service.exceptions.UserNotFoundException;
import com.azera.movs.exercise_01.domain.User;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalTime;
import java.util.UUID;

@Service
public class UserService implements UserManagementPort {

    UserStoragePort storagePort = new UserStorageAdapter(new ObjectMapper());

    @Override
    public void register(User user) {

        user.setId(UUID.randomUUID());
        user.setTime(LocalTime.now());

        //password hashing

        storagePort.save(user);
    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public User getUser(UUID uuid) {
        return storagePort.findById(uuid).orElseThrow(() -> new UserNotFoundException("User not found", uuid));
    }


}
