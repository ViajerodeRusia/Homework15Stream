package com.EmployeeBook.Homework15Stream.service;
import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    final List<Employee> employees = new ArrayList<>();

    @Override
    public String addEmployee(String name, String surname, Integer department, Integer salary) {
        if(employees.stream()
                        .filter(e -> e.getName().equals(name) && e.getSurname().equals(surname))
                        .findFirst()
                        .isEmpty()) {
            employees.add(new Employee(name, surname, department, salary));
            return "Новый сотрудник успешно добавлен";
        }
        throw new EmployeeAlreadyAddedException();
    }

    public List<Employee> AllEmployees() {
        return employees;
    }
    public List<Employee> AllEmployeesOfDepartment(Integer department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getAllEmployees(Integer command, Integer department) {
        return switch (command) {
            case 1 -> AllEmployees();
            case 2 -> AllEmployeesOfDepartment(department);
            default -> throw new RuntimeException();
        };
    }
}
