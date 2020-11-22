package com.landl.hcare.controller;

import com.landl.hcare.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    /*@Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> retrieveAllUsers() {
        return employeeService.findAll();
    }

    @GetMapping("/employeesByTitle/{title}")
    public List<Employee> retrieveAllUsersByTitle(@PathVariable String title) {
        return employeeService.findByTitle(title);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee retrieveByPatientId(@PathVariable Long employeeId) {
        Employee employee = employeeService.findById(employeeId).get();
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveUser(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }
*/
}
