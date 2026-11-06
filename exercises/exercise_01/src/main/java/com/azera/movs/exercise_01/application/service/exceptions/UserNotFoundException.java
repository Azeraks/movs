package com.azera.movs.exercise_01.application.service.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message, UUID uuid) {
        super("User: " + uuid + ", " + message);
    }
}
