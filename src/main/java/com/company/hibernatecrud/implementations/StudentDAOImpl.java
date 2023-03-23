package com.company.hibernatecrud.implementations;

import com.company.hibernatecrud.dao.StudentDAO;
import com.company.hibernatecrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager manager) {
        this.entityManager = manager;
    }

    @Override
    @Transactional
    public void create(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student readById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> readAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> readByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);

        query.setParameter("theData", lastName);
        return query.getResultList();
    }

    @Override
    public List<Student> readByFirstName(String firstName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where firstName=:theData", Student.class);

        query.setParameter("theData", firstName);
        return query.getResultList();
    }

    @Override
    public List<Student> readByEmail(String email) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student where email=:theData", Student.class);

        query.setParameter("theData", email);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateFirstName(Integer id, String newFirstName) {
        Student student = entityManager.find(Student.class, id);

        student.setFirstName(newFirstName);

        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateLastName(Integer id, String newLastName) {
        Student student = entityManager.find(Student.class, id);

        student.setLastName(newLastName);

        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateEmail(Integer id, String newEmail) {
        Student student = entityManager.find(Student.class, id);

        student.setEmail(newEmail);

        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Student student = entityManager.find(Student.class, id);

        entityManager.remove(student);
    }
//
//    @Override
//    @Transactional
//    public void deleteByFirstName(String firstName) {
//        TypedQuery<Student> query = entityManager.createQuery("FROM Student where firstName=:theData", Student.class);
//
//        query.setParameter("theData", firstName);
//        List<Student> students = query.getResultList();
//
//        for (int i = 0; i < students.size();) {
//            Student s = students.get(i);
//            if (s == null) {
//                i++;
//            } else {
//                entityManager.remove(s);
//            }
//        }
//    }
//
//    @Override
//    @Transactional
//    public void deleteByLastName(String lastName) {
//        TypedQuery<Student> query = entityManager.createQuery("FROM Student where lastName=:theData", Student.class);
//
//        query.setParameter("theData", lastName);
//        List<Student> students = query.getResultList();
//
//        for (int i = 0; i < students.size();) {
//            Student s = students.get(i);
//            if (s == null) {
//                i++;
//            } else {
//                entityManager.remove(s);
//            }
//        }
//    }
//
//    @Override
//    @Transactional
//    public void deleteByEmail(String email) {
//        TypedQuery<Student> query = entityManager.createQuery("FROM Student where email=:theData", Student.class);
//
//        query.setParameter("theData", email);
//        List<Student> students = query.getResultList();
//
//        for (int i = 0; i < students.size();) {
//            Student s = students.get(i);
//            if (s == null) {
//                i++;
//            } else {
//                entityManager.remove(s);
//            }
//        }
//    }
}
