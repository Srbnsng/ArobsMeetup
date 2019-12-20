package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.user.UserDTO;
import com.arobs.ArobsMeetup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable int id) throws ClassNotFoundException {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }
}
