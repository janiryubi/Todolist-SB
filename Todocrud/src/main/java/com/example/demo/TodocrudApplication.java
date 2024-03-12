package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Todo;

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
			
			Todo todo = new Todo();
			todo.setTitle("work");
			todo.setDone(true);
			em.persist(todo);
			
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
