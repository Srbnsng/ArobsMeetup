package com.arobs.ArobsMeetup.repository;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

@Repository
public class ProposalRepository implements IRepository<ProposalEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProposalRepository.class);

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void add(ProposalEntity elem) {
        LOGGER.info("  ==> ProposalRepository = add() ");
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    @Override
    public void update(ProposalEntity elem) {
        LOGGER.info("  ==> ProposalRepository =update() ");
        Session session = sessionFactory.getCurrentSession();
        session.update(elem);
    }

    @Override
    public void remove(ProposalEntity elem) {
        LOGGER.info("  ==> ProposalRepository = remove() ");
        Session session = sessionFactory.getCurrentSession();
        session.remove(elem);
    }

    @Override
    public ProposalEntity find(int id)  {
        LOGGER.info("  ==> ProposalRepository = find() ");
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProposalEntity.class,id);
    }


    @Override
    public List<ProposalEntity> findAll()  {
        LOGGER.info("  ==> ProposalRepository = findAll() ");
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<ProposalEntity> criteriaQuery = criteriaBuilder.createQuery(ProposalEntity.class);
        Root<ProposalEntity> root = criteriaQuery.from(ProposalEntity.class);
        criteriaQuery.select(root);
        Query<ProposalEntity> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }

}
