package com.arobs.ArobsMeetup.service.user;
import com.arobs.ArobsMeetup.constants.UserConstants;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.constants.RepositoryConstants;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private UserMapper userMapper;

    public void addUser(UserDTO userDTO) throws Exception {

        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        if(isRoleValid(userDTO.getRole())){
            UserEntity userEntity = userMapper.map(userDTO,UserEntity.class);
            repository.add(userEntity);
        }
        else{
            throw new Exception("User role invalid! ");
        }
    }

    private boolean isRoleValid(String role) {
        return role.equals(UserConstants.ADMIN_ROLE) || role.equals(UserConstants.REGULAR_ROLE);
    }


    public void removeUser(int id) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        if(user != null) {
            repository.remove(user);
        }
        else{
            throw new Exception("User id not found! ");
        }
    }

    public void alterUser(int id,UserDTO userDTO) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        if(user!=null){
            user.setFull_name(userDTO.getFull_name());
            user.setPassword(userDTO.getPassword());
            user.setEmail(userDTO.getEmail());
            user.setRole(userDTO.getRole());
            repository.update(user);
        }
        else{
            throw new Exception("User id not found! ");
        }

    }

    public UserDTO findUser(int id){
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        if(user != null) {
            return userMapper.map(user, UserDTO.class);
        }
        return null;
    }

    public List<UserDTO> findAllUsers(){
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        List<UserEntity> userEntities = repository.findAll();
        if(userEntities!=null) {
            return userMapper.mapAsList(userEntities, UserDTO.class);
        }

        return null;
    }

    public void addPoints(int id, int points) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        if(user!=null){
            user.setPoints(user.getPoints() + points);
            repository.update(user);
        }
        else{
            throw new Exception("User id not found! ");
        }

    }

}
