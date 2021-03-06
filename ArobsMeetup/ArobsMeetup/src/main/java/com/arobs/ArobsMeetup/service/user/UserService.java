package com.arobs.ArobsMeetup.service.user;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface UserService {

    void addUser(UserDTO userDTO) throws Exception;
    void removeUser(int id) throws Exception;
    void alterUser(int id, UserDTO userDTO) throws Exception;
    UserDTO findUser(int id);
    List<UserDTO> findAllUsers();
    List<UserDTO> getTopUserList();
}
