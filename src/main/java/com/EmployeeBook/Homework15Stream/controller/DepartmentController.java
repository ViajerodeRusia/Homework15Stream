package com.EmployeeBook.Homework15Stream.controller;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(@Autowired DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/allCosts")
    public Integer getCostsAllEmployees() {
        return  departmentService.getCostsAllEmployees();
    }
    @GetMapping(path = "/minSalary")
    public Employee getEmployeeWithMinSalary() {
        return departmentService.getEmployeeWithMinSalary();
    }
    @GetMapping(path = "/maxSalary")
    public Employee getEmployeeWithMaxSalary() {
        return departmentService.getEmployeeWithMaxSalary();
    }
    @GetMapping(path = "/minSalaryDep")
    public Employee getEmployeeWithMinSalaryDep(@RequestParam("department") Integer department) {
        return departmentService.getEmployeeWithMinSalaryDep(department);
    }
    @GetMapping(path = "/maxSalaryDep")
    public Employee getEmployeeWithMaxSalaryDep(@RequestParam ("department") Integer department) {
        return departmentService.getEmployeeWithMaxSalaryDep(department);
    }
    @GetMapping(path = "/allEmployeesOfDep")
    public List<Employee> getAllEmployees(@RequestParam ("department") Integer department){
        return departmentService.getAllEmployeesOfDepartment(department);
    }
}
