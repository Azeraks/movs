package com.azera.movs.exercise_01.adapter.controller.in;

import com.azera.movs.exercise_01.application.port.in.UserManagementPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    UserManagementPort userManagementPort;

    public UserController(UserManagementPort userManagementPort) {
        this.userManagementPort = userManagementPort;
    }

}
