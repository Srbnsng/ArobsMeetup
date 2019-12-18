package com.arobs.ArobsMeetup;

import com.arobs.ArobsMeetup.configuration.HibernateConfiguration;
import com.arobs.ArobsMeetup.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ArobsMeetupApplication {

	public static void main(String[] args) {

		SpringApplication.run(ArobsMeetupApplication.class,args);
		//UserEntity user = new UserEntity("pass","John Ionescu","Regular","johnio@gmail.com");

	}

}
