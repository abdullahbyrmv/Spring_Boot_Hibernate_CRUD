package com.company.hibernatecrud;

import com.company.hibernatecrud.dao.StudentDAO;
import com.company.hibernatecrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(StudentDAO student) {
        return runner -> {
            creatMultipleStudents(student);
        };
    }

    private void createStudent(StudentDAO student) {
        System.out.println("Creating new Student object...");
        Student tempStudent = new Student("Test", "sdadsa", "abayramov@gmail.com");

        System.out.println("Saving the student...");
        student.create(tempStudent);
    }

    private void creatMultipleStudents(StudentDAO student) {
        Student tempStudent = new Student("sfsd", "Mammadov", "mammadov11111@gmail.com");
        Student tempStudent1 = new Student("dsadsa", "dsfdgtrhgt", "testtester33333@gmail.com");
        Student tempStudent2 = new Student("dsadsa", "sdsfsfgfd", "fsdgfgthfhyt");
        Student tempStudent3 = new Student("Bug", "Reporter", "dfdgfgf");

        student.create(tempStudent);
        student.create(tempStudent1);
        student.create(tempStudent2);
        student.create(tempStudent3);
    }


    private void readStudent(StudentDAO student) {
        Student tempStudent = student.readById(1);

        System.out.println(tempStudent);
    }

    private void readAllStudents(StudentDAO student) {
        List<Student> students = student.readAll();

        for (Student tempStudent : students) {
            System.out.println();
            System.out.println(tempStudent);
        }
        System.out.println();
    }

    private void readByLastName(StudentDAO student) {
        List<Student> students = student.readByLastName("Tester");

        for (Student tempStudent : students) {
            System.out.println();
            System.out.println(tempStudent);
        }
        System.out.println();
    }

    private void readByFirstName(StudentDAO student) {
        List<Student> students = student.readByFirstName("Bug");

        for (Student tempStudent : students) {
            System.out.println();
            System.out.println(tempStudent);
        }
        System.out.println();
    }

    private void readByEmail(StudentDAO student) {
        List<Student> students = student.readByEmail("mammadov11111@gmail.com");

        for (Student tempStudent : students) {
            System.out.println();
            System.out.println(tempStudent);
        }
        System.out.println();
    }

    private void updateFirstName(StudentDAO student) {
        student.updateFirstName(2, "NewFirstName");
    }

    private void updateLastName(StudentDAO student) {
        student.updateLastName(4, "NewLastName");
    }

    private void updateEmail(StudentDAO student) {
        student.updateEmail(1, "NewEmail");
    }

    private void deleteById(StudentDAO student, Integer id) {
        student.deleteById(id);
    }

    private void deleteAll(StudentDAO student) {
        student.deleteAll();
    }

    private void deleteByFirstName(StudentDAO student) {
        student.deleteByFirstName();
    }

    private void deleteByLastName(StudentDAO student) {
        student.deleteByLastName();
    }

    private void deleteByEmail(StudentDAO student) {
        student.deleteByEmail();
    }
}
