package com.codewithkiks.cruddemo;

import com.codewithkiks.cruddemo.dao.StudentDAO;
import com.codewithkiks.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		Student student = new Student("Franc", "Steve", "francissteven1@gmail.com");

		// save the object
		System.out.println("Saving student..");
		studentDAO.save(student);

		// display the object's id
		System.out.println("Student saved successfully with id: " + student.getId());
	}

}
