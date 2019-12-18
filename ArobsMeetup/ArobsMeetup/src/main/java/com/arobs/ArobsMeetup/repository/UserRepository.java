package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository implements IRepository<UserEntity>{


    @Override
    public int add(UserEntity elem) {
        return 0;
    }

    @Override
    public int update(UserEntity elem) {
        return 0;
    }

    @Override
    public int remove(UserEntity elem) {
        return 0;
    }

    @Override
    public UserEntity find(int id) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }
}
