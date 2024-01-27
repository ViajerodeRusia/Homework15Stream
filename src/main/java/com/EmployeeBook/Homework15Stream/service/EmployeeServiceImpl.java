package com.EmployeeBook.Homework15Stream.service;
import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    final List<Employee> employees = new ArrayList<>();

    @Override
    public String addEmployee(String name, String surname, Integer department, Integer salary) {
        if(employees.stream().noneMatch(e -> e.getName().equals(name) && e.getSurname().equals(surname))) {
            employees.add(new Employee(name, surname, department, salary));
            return "Новый сотрудник успешно добавлен";
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
