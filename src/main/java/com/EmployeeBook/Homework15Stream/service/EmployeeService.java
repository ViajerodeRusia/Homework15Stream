package com.EmployeeBook.Homework15Stream.service;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
    List<Employee> getAllEmployees(Integer command,Integer department);
    String addEmployee(String name, String surname, Integer department, Integer salary);

}
