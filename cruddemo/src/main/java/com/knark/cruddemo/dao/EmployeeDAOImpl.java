package com.knark.cruddemo.dao;

import com.knark.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee>theQuery = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

        // excute query
        List<Employee> employees = theQuery.getResultList();

        // return
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        return theEmployee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee theEmployee = entityManager.merge(employee);
        return theEmployee;
    }

    @Override
    public void delete(Employee employee) {
        entityManager.remove(employee);


    }

    @Override
    public void deleteById(int id) {
        Employee theEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(theEmployee);
    }
}
