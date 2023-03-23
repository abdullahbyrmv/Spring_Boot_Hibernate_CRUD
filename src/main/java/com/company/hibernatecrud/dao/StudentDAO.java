package com.company.hibernatecrud.dao;

import com.company.hibernatecrud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void create(Student student);

    Student readById(Integer id);

    List<Student> readAll();

    List<Student> readByLastName(String lastName);

    List<Student> readByFirstName(String firstName);

    List<Student> readByEmail(String email);

    void updateFirstName(Integer id, String newFirstName);

    void updateLastName(Integer id, String newLastName);

    void updateEmail(Integer id, String newEmail);

    void deleteById(Integer id);
//
//    void deleteByFirstName(String firstName);
//
//    void deleteByLastName(String lastName);
//
//    void deleteByEmail(String email);
}
