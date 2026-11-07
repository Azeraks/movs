package com.azera.movs.exercise_01.application.port.in;

import com.azera.movs.exercise_01.domain.User;

import java.util.UUID;

public interface UserManagementPort {
    void register(User user);
    boolean deleteUser(UUID uuid);
    User getUser(UUID uuid);
}
