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
    public ResponseEntity<UserDTO> findUserById(@PathVariable int id){
        return ResponseEntity.ok(userService.findUser(id));
    }
    @GetMapping(path = "/")
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping(path = "/addUser")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
        try {
            userService.addUser(userDTO);
            return ResponseEntity.ok("New User created! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }
    @DeleteMapping(path = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        try {
            userService.removeUser(id);
            return ResponseEntity.ok("User with id "+ id + " deleted! ");

        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }
    @PutMapping(path = "/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id , @RequestBody UserDTO userDTO){
        try {
            userService.alterUser(id, userDTO);
            return ResponseEntity.ok("User with id " + id + " updated!");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }
    @GetMapping(path = "/userTopList")
    public ResponseEntity<List<UserDTO>> getUserTopList(){
        return ResponseEntity.ok(userService.getTopUserList());
    }

}


