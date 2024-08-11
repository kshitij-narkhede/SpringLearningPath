package com.knark.cruddemo.rest;


import com.knark.cruddemo.dao.EmployeeDAO;
import com.knark.cruddemo.entity.Employee;
import com.knark.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    //quick and dirty :inject DAO constructor injection
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //expose /employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    //add mapping for get request
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null)
            throw new RuntimeException("Employee not found--"+employeeId)   ;
        return theEmployee;
    }

    //Post request
    @PostMapping("/employees")
    public Employee addEmployee( @RequestBody Employee theEmployee) {
    theEmployee.setId(0);
    Employee dbEmployee=employeeService.save(theEmployee);
    return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee=employeeService.save(theEmployee);
        return dbEmployee;

    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee==null)
            throw new RuntimeException("Employee not found--"+employeeId)   ;
        employeeService.deleteById(employeeId);
        return "Deleted Employee--"+employeeId;


    }

    //
}
