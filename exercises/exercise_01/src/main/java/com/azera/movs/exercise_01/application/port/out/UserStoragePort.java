package com.azera.movs.exercise_01.application.port.out;

import com.azera.movs.exercise_01.domain.User;
import java.util.Optional;
import java.util.UUID;

public interface UserStoragePort {
    void save(User user);
    Optional<User> findById(UUID id);
    boolean deleteUser(UUID id);
}
