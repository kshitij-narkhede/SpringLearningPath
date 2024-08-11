package com.knark.cruddemo.dao;

import com.knark.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{

//define field for entity manager

    private final EntityManager entityManager;

// inject entity manager by constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
    entityManager.persist(theStudent);
    }

    @Override
    public Student findbyId(Integer Id) {
        return entityManager.find(Student.class, Id);
    }

    public List<Student> findAll() {
        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("select s from Student s order by lastName ", Student.class);
        // return query result
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery =entityManager.createQuery("select s from Student s where s.lastName = :theData", Student.class);
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer Id) {
        // retriev  student
        Student myStudent = findbyId(Id);
        System.out.println(myStudent);

        // delete
        entityManager.remove(myStudent);
        System.out.println("Student deleted");
    }

    @Override
    @Transactional
    public int deleteALl() {
        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numRowsDeleted;
    }
}










