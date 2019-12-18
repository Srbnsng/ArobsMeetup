package com.arobs.ArobsMeetup.repository;

import java.util.List;

public interface IRepository<T> {

    void add(T elem);
    void update(int id,T elem) ;
    void remove(T elem) ;
    T find(int id) ;
    List<T> findAll() ;
}
