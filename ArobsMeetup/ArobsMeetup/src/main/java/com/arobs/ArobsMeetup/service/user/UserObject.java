package com.arobs.ArobsMeetup.service.user;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryConstants;
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

    public void addUser(UserDTO userDTO){

        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity userEntity = userMapper.map(userDTO,UserEntity.class);
        repository.add(userEntity);

    }

    public void removeUser(int id){
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        if(user != null) {
            repository.remove(user);
        }
    }

    public void alterUser(int id,UserDTO userDTO){
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        user.setFull_name(userDTO.getFull_name());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        repository.update(user);
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

    public void addPoints(int id, int points){
        IRepository repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        UserEntity user = (UserEntity)repository.find(id);
        user.setPoints(user.getPoints() + points);
        repository.update(user);
    }

}
