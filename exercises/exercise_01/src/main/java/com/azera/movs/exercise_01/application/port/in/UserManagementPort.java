package com.azera.movs.exercise_01.application.port.in;

import com.azera.movs.exercise_01.adapter.controller.in.dto.RegisterUserRequest;

public interface UserManagementPort {
    void register(RegisterUserRequest registerUser);
}
