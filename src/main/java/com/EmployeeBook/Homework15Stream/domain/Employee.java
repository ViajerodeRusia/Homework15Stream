package com.EmployeeBook.Homework15Stream.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Employee {
    private String name;
    private String surname;
    private Integer department;
    private Integer salary;
    @JsonProperty(value = "ID")
    @EqualsAndHashCode.Exclude
    private Integer id;
    private static Integer counter = 0;

    public Employee(String name, String surname, Integer department, Integer salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.id = ++counter;
    }
}
