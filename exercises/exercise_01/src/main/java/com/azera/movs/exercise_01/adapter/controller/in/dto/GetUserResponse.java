package com.azera.movs.exercise_01.adapter.controller.in.dto;

import java.time.LocalTime;
import java.util.UUID;

public record GetUserResponse (
        String firstname,
        String lastname,
        UUID id,
        LocalTime time
){}
