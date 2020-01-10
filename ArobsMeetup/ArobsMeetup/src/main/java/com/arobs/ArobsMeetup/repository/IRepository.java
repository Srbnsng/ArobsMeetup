package com.arobs.ArobsMeetup.repository;

import java.util.List;

public interface IRepository<T> {

    void add(T elem);
    void update(T elem) ;
    void remove(T elem) ;
    T find(int id) ;
    List<T> findAll() ;
}
