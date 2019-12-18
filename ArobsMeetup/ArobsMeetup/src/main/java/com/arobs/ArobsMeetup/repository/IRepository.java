package com.arobs.ArobsMeetup.repository;

import java.util.List;

public interface IRepository<T> {

    int add(T elem);
    int update(T elem) ;
    int remove(T elem) ;
    T find(int id) ;
    List<T> findAll() ;
}
