package com.azera.movs.exercise_01.adapter.controller.out;

import com.azera.movs.exercise_01.application.port.out.UserStoragePort;
import com.azera.movs.exercise_01.domain.User;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class UserStorageAdapter implements UserStoragePort {

    private File data;
    private final ObjectMapper objectMapper;

    public UserStorageAdapter(ObjectMapper mapper) {

        this.objectMapper = mapper;

        try {
            data = new File("src/main/resources/data/userData.json");

            if(data.createNewFile()) {
                System.out.println("File successfully created");
            } else {
                System.out.println("File already exists");
            }
        } catch(IOException e) {
            System.out.println("UserStorageAdapter: IOException in constructor");
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        try {
            objectMapper.writeValue(data, user);
        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }
}
