package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.HelloEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootApplication
public class TodocrudApplication {

	public static void main(String[] args) {
		//SpringApplication.run(TodocrudApplication.class, args);
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPATest");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			HelloEntity hello = new HelloEntity();
			hello.setName("hong");
			hello.setGreeting("Hello world");
			em.persist(hello);
			
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
