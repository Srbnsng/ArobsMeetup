package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class EventRepository implements DBRepository<EventEntity> {

    @Override
    public int add(EventEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public int update(EventEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public int remove(EventEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public EventEntity find(int id) throws SQLException {
        return null;
    }

    @Override
    public List<EventEntity> findAll() throws SQLException {
        return null;
    }
}
