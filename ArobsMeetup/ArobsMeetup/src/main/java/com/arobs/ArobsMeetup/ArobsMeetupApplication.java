package com.arobs.ArobsMeetup;

import com.arobs.ArobsMeetup.configuration.HibernateConfiguration;
import com.arobs.ArobsMeetup.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ArobsMeetupApplication {

	public static void main(String[] args) {

		Session session = HibernateConfiguration.getSessionFactory().openSession();
		session.beginTransaction();

//		Query<UserEntity> query = session.createNativeQuery("select * from user");
//		List<UserEntity> users= query.list();


		UserEntity user = new UserEntity("123","Johnny Cushca","Admin","ionica@hotmail.com");

		session.save(user);
		Query<UserEntity> query = session.createQuery("from UserEntity");
		List<UserEntity> users = query.list();

		System.out.println(users.size());
		for(UserEntity u : users) {
			System.out.println(u.toString());
		}

		session.getTransaction().commit();
		session.close();


		HibernateConfiguration.shutdown();
	}

}
