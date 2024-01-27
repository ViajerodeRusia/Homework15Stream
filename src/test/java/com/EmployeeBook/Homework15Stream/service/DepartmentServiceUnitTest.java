package com.EmployeeBook.Homework15Stream.service;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceUnitTest {
    @InjectMocks //созд объект и инджектим сюда
    DepartmentServiceImpl departmentServiceImpl;
    @Mock
    EmployeeService employeeService;
    //Unit(модульное) - конкр метод и Интеграционное -  отработка метода с учетом зависимостей внутри метода не тестируем
    //Делаем Unit, проверяем только тот код со стрима. НЕ ПРОВЕРЯЕМ ВОЗВРАЩАЕМЫЙ СПИСОК Employee
    @Test
    void getEmployeeWithMinSalaryDep() {
        Mockito.when(employeeService.getAllEmployees()).thenReturn(List.of(
                new Employee("Denis", "Siliukov", 1, 1000),
                new Employee("Dasha", "Siliukova", 1, 900)
        ));
        Employee answer = departmentServiceImpl.getEmployeeWithMinSalaryDep(1);
        Assertions.assertEquals(900, answer.getSalary());
    }
}