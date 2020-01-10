package com.arobs.ArobsMeetup.repository;

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
public class UserRepository implements IRepository<UserEntity>{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(UserEntity elem) {

        LOGGER.info("  ==> UserRepository = add() ");
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    @Override
    public void update(UserEntity elem) {

        LOGGER.info("  ==> UserRepository = update() ");
        Session session = sessionFactory.getCurrentSession();
        session.update(elem);

    }

    @Override
    public void remove(UserEntity elem) {
        LOGGER.info("  ==> UserRepository = remove() ");
        Session session = sessionFactory.getCurrentSession();
        session.remove(elem);
    }

    @Override
    public UserEntity find(int id) {
        LOGGER.info("  ==> UserRepository = find() ");
        Session session = sessionFactory.getCurrentSession();
        return session.get(UserEntity.class , id);
    }

    @Override
    public List<UserEntity> findAll() {
        LOGGER.info("  ==> UserRepository = findAll() ");
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
        criteriaQuery.select(root);
        Query<UserEntity> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
