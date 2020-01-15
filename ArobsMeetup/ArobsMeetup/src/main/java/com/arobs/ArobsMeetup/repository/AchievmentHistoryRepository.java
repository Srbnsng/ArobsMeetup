package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.AchievementHistoryEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AchievmentHistoryRepository implements IRepository<AchievementHistoryEntity>{

    @Autowired
    SessionFactory sessionFactory;

    public void add(AchievementHistoryEntity elem){
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    public void update(AchievementHistoryEntity elem){
        Session session = sessionFactory.getCurrentSession();
        session.update(elem);
    }

    public void remove(AchievementHistoryEntity elem){
        Session session = sessionFactory.getCurrentSession();
        session.remove(elem);
    }

    public AchievementHistoryEntity find(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(AchievementHistoryEntity.class,id);
    }

    public List<AchievementHistoryEntity> findAll(){
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<AchievementHistoryEntity> criteriaQuery = criteriaBuilder.createQuery(AchievementHistoryEntity.class);
        Root<AchievementHistoryEntity> root = criteriaQuery.from(AchievementHistoryEntity.class);
        criteriaQuery.select(root);
        Query<AchievementHistoryEntity> query = session.createQuery(criteriaQuery);

        return query.getResultList();
    }
}
