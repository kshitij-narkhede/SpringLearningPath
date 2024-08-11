package com.knark.cruddemo.service;

import com.knark.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(Employee employee);
    void deleteById(int id);
}
