package com.arobs.ArobsMeetup.repository;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface DBRepository<T> {

    int add(T elem) throws SQLException;
    int update(T elem) throws SQLException;
    int remove(T elem) throws  SQLException;
    T find(int id) throws SQLException;
    List<T> findAll() throws SQLException;
}
