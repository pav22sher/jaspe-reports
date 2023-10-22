package com.example.jaspereports.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String org;
    private int salary;

    public static List<Employee> getEmployees() {
        return List.of(
                new Employee(1, "Name1", "Org1", 1000),
                new Employee(2, "Name2", "Org2", 2000),
                new Employee(3, "Name3", "Org3", 3000),
                new Employee(4, "Name4", "Org4", 4000)
        );
    }
}
