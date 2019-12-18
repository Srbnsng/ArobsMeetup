package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
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
public class EventRepository implements IRepository<EventEntity> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(EventEntity elem) {

        LOGGER.info("  ==> EventRepository = add() ");
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    @Override
    public void update(int id,EventEntity elem){
        LOGGER.info("  ==> EventRepository = update() ");
        Session session = sessionFactory.getCurrentSession();
        session.update(elem);
    }

    @Override
    public void remove(EventEntity elem) {
        LOGGER.info("  ==> EventRepository = remove() ");
        Session session = sessionFactory.getCurrentSession();
        session.remove(elem);
    }

    @Override
    public EventEntity find(int id)  {
        LOGGER.info("  ==> EventRepository = find() ");
        Session session = sessionFactory.getCurrentSession();
        return session.get(EventEntity.class,id);
    }

    @Override
    public List<EventEntity> findAll() {
        LOGGER.info("  ==> EventRepository = findAll() ");
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<EventEntity> criteriaQuery = criteriaBuilder.createQuery(EventEntity.class);
        Root<EventEntity> root = criteriaQuery.from(EventEntity.class);
        criteriaQuery.select(root);
        Query<EventEntity> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
