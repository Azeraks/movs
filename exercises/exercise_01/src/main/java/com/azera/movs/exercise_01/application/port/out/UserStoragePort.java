package com.azera.movs.exercise_01.application.port.out;

import com.azera.movs.exercise_01.domain.User;

public interface UserStoragePort {
    void save(User user);
}
