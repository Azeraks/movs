package com.azera.movs.exercise_05.adapter.controller.in.dto;

public record RegisterUserRequest(
        String firstname,
        String lastname,
        String password
){}
