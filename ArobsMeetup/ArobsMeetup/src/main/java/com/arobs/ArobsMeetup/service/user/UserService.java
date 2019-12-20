package com.arobs.ArobsMeetup.service.user;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    void addUser(UserDTO userDTO);
    void removeUser(int id);
    UserDTO findUser(int id);
    List<UserDTO> findAllUsers();
}
