package com.azera.movs.exercise_01.adapter.controller.out;

import com.azera.movs.exercise_01.application.port.out.UserStoragePort;
import com.azera.movs.exercise_01.domain.User;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;

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
            List<User> users = new ArrayList<>();

            if(data.exists() && data.length() > 0) {
                users = objectMapper.readValue(data, new TypeReference<ArrayList<User>>() {});
            }

            users.add(user);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(data, users);

        } catch (JacksonException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<User> findById(UUID id) {
        List<User> userList = objectMapper.readValue(data, new TypeReference<ArrayList<User>>() {});

        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findAny();
    }

    @Override
    public boolean deleteUser(UUID id) {

       List<User> userList = objectMapper.readValue(data, new TypeReference<ArrayList<User>>() {});

       int index = IntStream.range(0, userList.size())
               .filter(i -> userList.get(i).getId().equals(id))
               .findFirst()
               .orElse(-1);

       if(index != -1) {
           userList.remove(index);
           objectMapper.writerWithDefaultPrettyPrinter().writeValue(data, userList);
       }
        return false;
    }
}
