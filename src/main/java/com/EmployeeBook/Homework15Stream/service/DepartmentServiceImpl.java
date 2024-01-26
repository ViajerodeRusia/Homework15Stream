package com.EmployeeBook.Homework15Stream.service;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee getEmployeeWithMinSalaryDep(Integer department) {
        return employeeService.getAllEmployees(1,null).stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    @Override
    public Employee getEmployeeWithMaxSalaryDep(Integer department) {
        return employeeService.getAllEmployees(1,null).stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }
    @Override
    public Integer getCostsAllEmployees() {
        Integer sum = employeeService.getAllEmployees(1,null).stream()
                .map(Employee::getSalary)
                .flatMapToInt(IntStream::of)
                .sum();
        return sum;
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return employeeService.getAllEmployees(1,null).stream()
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return employeeService.getAllEmployees(1,null).stream()
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }
    @Override
    public List<Employee> getAll(Integer command, Integer department) {
        return employeeService.getAllEmployees(command, department);
    }
    @Override
    public String add(String name, String surname, Integer department, Integer salary) {
        return employeeService.addEmployee(name, surname, department, salary);
    }
}
