package com.knark.cruddemo;

import com.knark.cruddemo.dao.HabitDAO;
import com.knark.cruddemo.dao.StudentDAO;
import com.knark.cruddemo.entity.Habit;
import com.knark.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, HabitDAO habitDAO){
		return  runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
//			deleteAllStudent(studentDAO);

			addHabit(habitDAO);

		};
	}

	private void addHabit(HabitDAO habitDAO) {
		System.out.println("Creating Habit object" );
		Habit tempHabit = new Habit("Drink Water","Drink water daily 5 liters",true);

		// save student object
		System.out.println("Saving habit object");
		habitDAO.save(tempHabit);

		//display id of saved student
		System.out.println("Saved Habit object, Generated id: " + tempHabit.getId());
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted= studentDAO.deleteALl();
		System.out.println("Deleted "+numRowsDeleted+" students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=6;
		System.out.println("Deleting student "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrive student based on ID

		int studentId = 6;
		System.out.println("Getting Student Id "+studentId)	;
		Student myStudent=studentDAO.findbyId(studentId);

		//change lastname narkhede
		System.out.println("Updating Student "+myStudent.getFirstName()+" "+myStudent.getLastName());
		myStudent.setLastName("Narkhede");



		//update
		studentDAO.update(myStudent);
		//display
		System.out.println("Updated Student "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> students = studentDAO.findByLastName("nark");
		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
		System.out.println("Success");
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of student
		List<Student> theStudents = studentDAO.findAll();
		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new Student");
		Student tempStudent = new Student("Knark","nark","kshitij@hotmail.com");

		// save a student
		System.out.println("Saving student");
		studentDAO.save(tempStudent);

		//display id of student
		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated Id"+ theId);

		// retriev
		System.out.println("Retrieving Student with "+ theId);
		Student myStudent=studentDAO.findbyId(theId);

		// display
		System.out.println("Found Student " + myStudent);

		// display student
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("Create multiple student");
		Student tempStudent1 = new Student("Kshitija","Narkhedea","kshitij1@gmail.com")	;
		Student tempStudent2 = new Student("Kshitijaa","Narkhedeaa","kshitij2@gmail.com")	;
		Student tempStudent3 = new Student("Kshitijaaa","Narkhedeaaa","kshitij3@gmail.com")	;
		System.out.println("Saving Multiple Students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating student object" );
		Student tempStudent = new Student("Kshitij","Narkhede","kshitij@gmail.com")	;


		// save student object
		System.out.println("Saving student object");
		studentDAO.save(tempStudent);

		//display id of saved student
		System.out.println("Saved student object, Generated id: " + tempStudent.getId());
	}
}
