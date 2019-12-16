package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.VoteEntity;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class ProposalVotesRepository implements DBRepository<VoteEntity> {


    @Override
    public int add(VoteEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public int update(VoteEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public int remove(VoteEntity elem) throws SQLException {
        return 0;
    }

    @Override
    public VoteEntity find(int id) throws SQLException {
        return null;
    }

    @Override
    public List<VoteEntity> findAll() throws SQLException {
        return null;
    }
}
