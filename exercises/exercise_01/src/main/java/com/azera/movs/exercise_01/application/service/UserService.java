package com.azera.movs.exercise_01.application.service;

import com.azera.movs.exercise_01.adapter.controller.in.dto.RegisterUserRequest;
import com.azera.movs.exercise_01.application.port.in.UserManagementPort;
import com.azera.movs.exercise_01.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.UUID;

@Service
public class UserService implements UserManagementPort {

    @Override
    public void register(RegisterUserRequest request) {

        LocalTime currentTime = LocalTime.now();
        UUID uuid = UUID.randomUUID();

        User user = new User(
                request.firstname(),
                request.lastname(),
                request.password(),
                uuid,
                currentTime
        );
    }

    public void delete() {

    }

    public void getUser() {

    }

    public void getAllUsers() {

    }
}
