package com.azera.movs.exercise_05.adapter.controller.in;

import com.azera.movs.exercise_05.adapter.controller.in.dto.DeleteUserResponse;
import com.azera.movs.exercise_05.adapter.controller.in.dto.GetUserResponse;
import com.azera.movs.exercise_05.adapter.controller.in.dto.RegisterUserRequest;
import com.azera.movs.exercise_05.adapter.controller.in.dto.RegisterUserResponse;
import com.azera.movs.exercise_05.application.port.in.UserManagementPort;
import com.azera.movs.exercise_05.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    UserManagementPort userManagementPort;

    public UserController(UserManagementPort userManagementPort) {
        this.userManagementPort = userManagementPort;
    }


    @PostMapping("/registration")
    ResponseEntity<RegisterUserResponse> registerUser(@RequestBody RegisterUserRequest requestUser) {
        try {
            User newUser = new User(
                    requestUser.firstname(),
                    requestUser.lastname(),
                    requestUser.password()
            );
            userManagementPort.register(newUser);

        } catch (RuntimeException e) {
            System.out.println("hier?");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new RegisterUserResponse("User successfully created"));
    }


    @GetMapping("/{id}")
    ResponseEntity<GetUserResponse> getUser(@PathVariable UUID id) {
        try {
            User user = userManagementPort.getUser(id);

            GetUserResponse response = new GetUserResponse(
                    user.getFirstname(),
                    user.getLastname(),
                    user.getId(),
                    user.getTime()
            );
            return ResponseEntity.status(HttpStatus.FOUND).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<DeleteUserResponse> deleteUser(@PathVariable UUID id) {

        DeleteUserResponse response;

        if(!userManagementPort.deleteUser(id)) {
            response = new DeleteUserResponse(
                    "User was successfully deleted"
            );
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        response = new DeleteUserResponse("User could not be deleted");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
