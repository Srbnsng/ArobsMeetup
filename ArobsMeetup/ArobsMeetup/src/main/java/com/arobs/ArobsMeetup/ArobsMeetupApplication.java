package com.arobs.ArobsMeetup;

import com.arobs.ArobsMeetup.configuration.HibernateUtils;
import com.arobs.ArobsMeetup.entity.UserEntity;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ArobsMeetupApplication {

	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();

		//String SQL_QUERRY = "SELECT * FROM `User`";
		String SQL_QUERRY = "select version()";
		//List<UserEntity> users= (List<UserEntity>)session.createNativeQuery(SQL_QUERRY).list();
		String result = session.createNativeQuery(SQL_QUERRY).getSingleResult().toString();
//		for(UserEntity u : users)
//			System.out.println(u.toString());
		System.out.println(result);
		session.getTransaction().commit();
		session.close();


		HibernateUtils.shutdown();
		//SpringApplication.run(ArobsMeetupApplication.class, args);
	}

}
