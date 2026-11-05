package com.azera.movs.exercise_01.adapter.controller.in;

import com.azera.movs.exercise_01.adapter.controller.in.dto.RegisterUserRequest;
import com.azera.movs.exercise_01.adapter.controller.in.dto.RegisterUserResponse;
import com.azera.movs.exercise_01.application.port.in.UserManagementPort;
import com.azera.movs.exercise_01.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    UserManagementPort userManagementPort;

    public UserController(UserManagementPort userManagementPort) {
        this.userManagementPort = userManagementPort;
    }


    @PostMapping
    @RequestMapping("/registration")
    ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest requestUser) {

        try {
            User newUser = new User(
                    requestUser.firstname(),
                    requestUser.lastname(),
                    requestUser.password()
            );

            userManagementPort.register(newUser);
        } catch (RuntimeException e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse("User successfully created"));
    }




}
