package com.arobs.ArobsMeetup.service.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserObject userObject;


    @Override @Transactional
    public void addUser(UserDTO userDTO) {
        userObject.addUser(userDTO);
    }

    @Override @Transactional
    public void removeUser(int id) {
        userObject.removeUser(id);
    }

    @Override @Transactional
    public UserDTO findUser(int id) {
        return userObject.findUser(id);
    }

    @Override @Transactional
    public List<UserDTO> findAllUsers() {
        return userObject.findAllUsers();
    }
}