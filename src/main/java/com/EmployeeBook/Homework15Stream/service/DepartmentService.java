package com.EmployeeBook.Homework15Stream.service;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    Integer getCostsAllEmployees();
    Employee getEmployeeWithMinSalary();
    Employee getEmployeeWithMaxSalary();
    Employee getEmployeeWithMinSalaryDep(Integer department);
    Employee getEmployeeWithMaxSalaryDep(Integer department);
    List<Employee> getAllEmployeesOfDepartment(Integer department);
}
