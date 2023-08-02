package com.demo.management.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
