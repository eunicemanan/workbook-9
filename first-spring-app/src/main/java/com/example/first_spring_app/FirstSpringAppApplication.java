package com.example.first_spring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstSpringAppApplication {


	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(com.example.first_spring_app.FirstSpringAppApplication.class, args);


		// Get all bean names and sort them alphabetically
//		String[] beanNames = context.getBeanDefinitionNames();
//		Arrays.sort(beanNames);

		// Print each bean name
//		System.out.println("Beans provided by Spring Boot:");
//		for (String beanName : beanNames) {
//			System.out.println(beanName);
//		}


//		PersonDAO personDAO =new PersonDAO();
//		PersonDAO personDAO = context.getBean(PersonDAO.class);
//		Person person = personDAO.find();
//		System.out.println(person);

	}

}