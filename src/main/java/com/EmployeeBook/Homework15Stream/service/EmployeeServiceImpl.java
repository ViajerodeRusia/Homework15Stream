package com.EmployeeBook.Homework15Stream.service;
import com.EmployeeBook.Homework15Stream.domain.Employee;
import com.EmployeeBook.Homework15Stream.exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>();

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

    @Override
    public Employee getEmployeeWithMinSalaryDep(Integer department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }

    @Override
    public Employee getEmployeeWithMaxSalaryDep(Integer department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equals(department))
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Integer getCostsAllEmployees() {
        Integer sum = employees.stream()
                .map(Employee::getSalary)
                .flatMapToInt(IntStream::of)
                .sum();
        return sum;
    }

    @Override
    public Employee getEmployeeWithMinSalary() {
        return employees.stream()
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }

    @Override
    public Employee getEmployeeWithMaxSalary() {
        return employees.stream()
                .max(Comparator.comparingInt(e -> e.getSalary()))
                .get();
    }
}
