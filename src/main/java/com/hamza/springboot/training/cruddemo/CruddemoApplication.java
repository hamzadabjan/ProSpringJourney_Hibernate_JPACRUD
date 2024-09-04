package com.hamza.springboot.training.cruddemo;

import com.hamza.springboot.training.cruddemo.dao.StudentDAO;
import com.hamza.springboot.training.cruddemo.dao.StudentDAOImpl;
import com.hamza.springboot.training.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CruddemoApplication {


	private String firstName,lastName, email;
	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number Of Deleted Rows: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+ studentId);
		Student myStudent=studentDAO.findById(studentId);

		// change first name to "Manu"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Hanan");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: "+ myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents=studentDAO.findByLastName("Ayman");

		for ( Student temStudent : theStudents){
			System.out.println(temStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List <Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void createStudent(StudentDAO studentDAO){

		// create the student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Hamza", "Dabjan", "hamza.dabjan@gmail.com");


		// save the student object
		System.out.println("Saving the student....");
		studentDAO.save(tempStudent);



		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		Student myStudent=studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: "+myStudent);


	}
}