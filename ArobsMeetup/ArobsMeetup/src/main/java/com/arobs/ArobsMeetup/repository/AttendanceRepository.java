package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.AttendanceEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AttendanceRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteRepository.class);

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    UserRepository userRepository;
    @Autowired
    EventRepository eventRepository;

    public void add(AttendanceEntity elem){
        LOGGER.info("  ==> AttendanceRepository = add() ");
        Session session = sessionFactory.getCurrentSession();
        session.save(elem);
    }

    public void remove(AttendanceEntity elem){
        LOGGER.info("  ==> AttendanceRepository = remove() ");
        Session session = sessionFactory.getCurrentSession();
        session.remove(elem);
    }

    public void update(AttendanceEntity elem){
        LOGGER.info("  ==> AttendanceRepository = update() ");
        Session session = sessionFactory.getCurrentSession();
        session.update(elem);
    }

    public AttendanceEntity find(int id){
        LOGGER.info("  ==> UserRepository = find() ");
        Session session = sessionFactory.getCurrentSession();
        return session.get(AttendanceEntity.class , id);
    }

    public List<AttendanceEntity> getAllAttendancesOfAnEvent(int id_event){

        Session session = sessionFactory.getCurrentSession();
        return session.createNativeQuery("select * from attendance where id_event =?")
                .setParameter(1, id_event).addEntity(AttendanceEntity.class).list();
    }

    public List<AttendanceEntity> getAllAttendancesOfAnUser(int id_user){
        Session session = sessionFactory.getCurrentSession();
        return session.createNativeQuery("select * from attendance where id_user =?")
                .setParameter(1, id_user).addEntity(AttendanceEntity.class).list();
    }

    public double getAverageMarkOfAnEvent(int id_event){
        Session session = sessionFactory.getCurrentSession();
        Number averageMark = (Number)session.createNativeQuery("select AVG(mark) as AverageMark from Attendance where id_event =?")
                .setParameter(1, id_event).getSingleResult();

        return averageMark.doubleValue();
    }

}
