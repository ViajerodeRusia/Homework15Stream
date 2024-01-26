package com.EmployeeBook.Homework15Stream.controller;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.service.DepartmentService;
import com.EmployeeBook.Homework15Stream.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {
    private final DepartmentService departmentService;

    public MainController(@Autowired DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/department/allCosts")
    public Integer getCostsAllEmployees() {
        return  departmentService.getCostsAllEmployees();
    }
    @GetMapping(path = "/department/minSalary")
    public Employee getEmployeeWithMinSalary() {
        return departmentService.getEmployeeWithMinSalary();
    }
    @GetMapping(path = "/department/maxSalary")
    public Employee getEmployeeWithMaxSalary() {
        return departmentService.getEmployeeWithMaxSalary();
    }
    @GetMapping(path = "/department/minSalaryDep")
    public Employee getEmployeeWithMinSalaryDep(@RequestParam("department") Integer department) {
        return departmentService.getEmployeeWithMinSalaryDep(department);
    }
    @GetMapping(path = "/department/maxSalaryDep")
    public Employee getEmployeeWithMaxSalaryDep(@RequestParam ("department") Integer department) {
        return departmentService.getEmployeeWithMaxSalaryDep(department);
    }
    @GetMapping(path = "/employee/allEmployees/{command}")
    public List<Employee> getAllEmployees(@PathVariable("command") Integer command,
                                          @RequestParam(value = "department", required = false) Integer department){
        return departmentService.getAll(command,department);
    }
    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam ("name") String name, @RequestParam ("surname") String surname,
                              @RequestParam ("department") Integer department, @RequestParam ("salary") Integer salary) {
        return departmentService.add(name, surname, department, salary);
    }
}
