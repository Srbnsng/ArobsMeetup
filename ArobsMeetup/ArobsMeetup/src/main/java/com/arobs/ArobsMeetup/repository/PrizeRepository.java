package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.PrizeEntity;
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

@Repository
public class PrizeRepository implements IRepository<PrizeEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProposalRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(PrizeEntity elem) {
        LOGGER.info("  ==> PrizeRepository = add() ");
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    @Override
    public void update(PrizeEntity elem) {
        LOGGER.info("  ==> PrizeRepository = add() ");
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    @Override
    public void remove(PrizeEntity elem) {
        LOGGER.info("  ==> PrizeRepository = remove() ");
        Session session = sessionFactory.getCurrentSession();
        session.remove(elem);
    }

    @Override
    public PrizeEntity find(int id) {
        LOGGER.info("  ==> PrizeRepository = find() ");
        Session session = sessionFactory.getCurrentSession();
        return session.get(PrizeEntity.class,id);
    }

    @Override
    public List<PrizeEntity> findAll() {
        LOGGER.info("  ==> PrizeRepository = findAll() ");
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PrizeEntity> criteriaQuery = criteriaBuilder.createQuery(PrizeEntity.class);
        Root<PrizeEntity> root = criteriaQuery.from(PrizeEntity.class);
        criteriaQuery.select(root);
        Query<PrizeEntity> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
