package com.EmployeeBook.Homework15Stream.service;

import com.EmployeeBook.Homework15Stream.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;
    private Employee employee5;
    private Employee employee6;
    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Denis","Siliukov",1,150_000);
        employee2 = new Employee("Dasha","Siliukova",1,140_000);
        employee3 = new Employee("Svetlana","Gerasimova",3,200_000);
        employee4 = new Employee("Ekaterina","Siliukova",2,60_000);
        employee5 = new Employee("Oleg","Gerasimov",3,170_000);
        employee6 = new Employee("Elena","Gerasimova",3,60_000);
    }

    @Test
    void getAllEmployees() {
    }

    @Test
    void addEmployee() {
    }
}