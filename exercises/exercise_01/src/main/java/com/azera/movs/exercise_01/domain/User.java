package com.azera.movs.exercise_01.domain;

import lombok.Setter;
import lombok.Getter;

import java.time.LocalTime;
import java.util.UUID;

@Setter
@Getter
public class User {
    private String firstname;
    private String lastname;
    private String password;
    private UUID id;
    private LocalTime time;

    public User(String f, String l, String p) {
        this.firstname = f;
        this.lastname = l;
        this.password = p;
    }
}
