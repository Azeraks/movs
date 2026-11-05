package com.azera.movs.exercise_01.application.port.in;

import com.azera.movs.exercise_01.domain.User;

public interface UserManagementPort {
    void register(User user);
}
