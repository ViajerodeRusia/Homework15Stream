package com.EmployeeBook.Homework15Stream.service;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeService {
/**
 * "1. Получить список всех сотрудников."
 * "2. Посчитать сумму затрат на зарплаты."
 * "3. Найти сотрудника с минимальной заплатой."
 * "4. Найти сотрудника с максимальной зарплатой."
 * "5. Подсчитать среднее значение зарплат."
 * "6. Вывод по id."
 * "7. Индексация зарплат."
 * "8. Данные по департаменту."
 * "9. Отсечка по зарплате."
 */
    List<Employee> getAllEmployees();
    Integer getCostsAllEmployees();
    Employee getEmployeeWithMinSalary();
    Employee getEmployeeWithMaxSalary();
    String addEmployee(String name, String surname, Integer department, Integer salary);

}
