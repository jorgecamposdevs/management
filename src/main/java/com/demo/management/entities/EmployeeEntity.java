package com.demo.management.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("employees")
public class EmployeeEntity {

    @Id
    private String id;

    private String name;

    private String job;

    private double salary;

    private String phone;

    private String address;
}
