package com.EmployeeBook.Homework15Stream.controller;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam ("name") String name, @RequestParam ("surname") String surname,
                              @RequestParam ("department") Integer department, @RequestParam ("salary") Integer salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }
}
