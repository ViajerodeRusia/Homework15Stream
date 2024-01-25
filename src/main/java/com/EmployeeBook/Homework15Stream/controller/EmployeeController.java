package com.EmployeeBook.Homework15Stream.controller;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/allEmployees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping(path = "/allCosts")
    public Integer getCostsAllEmployees() {
        return  employeeService.getCostsAllEmployees();
    }
    @GetMapping(path = "/minSalary")
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getEmployeeWithMinSalary();
    }
    @GetMapping(path = "/maxSalary")
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getEmployeeWithMaxSalary();
    }
    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam ("name") String name, @RequestParam ("surname") String surname,
                              @RequestParam ("department") Integer department, @RequestParam ("salary") Integer salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }
    @GetMapping(path = "/minSalaryDep")
    public Employee getEmployeeWithMinSalaryDep(@RequestParam ("department") Integer department) {
        return employeeService.getEmployeeWithMinSalaryDep(department);
    }
    @GetMapping(path = "/maxSalaryDep")
    public Employee getEmployeeWithMaxSalaryDep(@RequestParam ("department") Integer department) {
        return employeeService.getEmployeeWithMaxSalaryDep(department);
    }
}
