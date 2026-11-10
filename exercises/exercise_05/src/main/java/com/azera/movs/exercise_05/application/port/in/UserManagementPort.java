package com.azera.movs.exercise_05.application.port.in;

import com.azera.movs.exercise_05.domain.User;

import java.util.UUID;

public interface UserManagementPort {
    void register(User user);
    boolean deleteUser(UUID uuid);
    User getUser(UUID uuid);
}
