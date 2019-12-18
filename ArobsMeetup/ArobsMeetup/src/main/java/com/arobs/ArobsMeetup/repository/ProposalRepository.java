package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.configuration.Datasource;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProposalRepository implements IRepository<ProposalEntity> {


    public ProposalRepository() {}

    @Override
    public int add(ProposalEntity proposal) {
        return 0;
    }

    @Override
    public int update(ProposalEntity elem) {
        return 0;
    }

    @Override
    public int remove(ProposalEntity elem) {
        return 0;
    }

    @Override
    public ProposalEntity find(int id)  {
        return null;
    }

    @Override
    public List<ProposalEntity> findAll()  {
        return null;
    }
}
