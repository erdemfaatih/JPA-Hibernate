package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId =2;
		System.out.println("Getting student with id : "+studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleted with id : "+ studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId =1;

		System.out.println("Getting student with id :"+studentId);
		Student student = studentDAO.findById(studentId);

		System.out.println("Updating student...");
		student.setFirstName("Emre");

		studentDAO.update(student);
		System.out.println("Updated student : "+student);

	}


	private void queryForByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("erdem");
		for (Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudentList = studentDAO.findAll();

		for (Student student : theStudentList){
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object ...");
		Student student = new Student("Elif","Yücesoy","elif@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(student);

		int theId= student.getId();
		System.out.println("Saved student. Generated id : "+theId);

		System.out.println("Retrieving student with id : "+theId);
		Student newStudent = studentDAO.findById(theId);

		System.out.println("Found the student : "+ newStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		//CREATE THE STUDENT OBJECT
		System.out.println("Creating new student object...");
		Student theStudent = new Student("Emre","erdem","emre@gmail.com");
		Student theStudent1 = new Student("Erdal","erdem","erdal@gmail.com");
		Student theStudent2 = new Student("Güllü","erdem","gullu@gmail.com");

		//SAVE THE STUDENT OBJECT
		System.out.println("Saving student ...");
		studentDAO.save(theStudent);
		studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);

		//DISPLAY ID OF SAVED STUDENT
		System.out.println("Display student. Generated id : "+theStudent.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		//CREATE THE STUDENT OBJECT
		System.out.println("Creating new student object...");
		Student theStudent = new Student("fatih","erdem","me.fatiherdem@gmail.com");

		//SAVE THE STUDENT OBJECT
		System.out.println("Saving student ...");
		studentDAO.save(theStudent);

		//DISPLAY ID OF SAVED STUDENT
		System.out.println("Display student. Generated id : "+theStudent.getId());
	}

}
