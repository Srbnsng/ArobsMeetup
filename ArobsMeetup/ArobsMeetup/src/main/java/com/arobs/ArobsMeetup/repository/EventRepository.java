package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventRepository implements IRepository<EventEntity> {

    @Override
    public int add(EventEntity elem) {
        return 0;
    }

    @Override
    public int update(EventEntity elem) {
        return 0;
    }

    @Override
    public int remove(EventEntity elem) {
        return 0;
    }

    @Override
    public EventEntity find(int id)  {
        return null;
    }

    @Override
    public List<EventEntity> findAll() {
        return null;
    }
}
