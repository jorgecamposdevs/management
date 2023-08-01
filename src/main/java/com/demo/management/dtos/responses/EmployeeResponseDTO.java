package com.demo.management.dtos.responses;

import lombok.Data;

@Data
public class EmployeeResponseDTO {

    private String id;

    private String name;

    private String job;

    private double salary;

    private String phone;

    private String address;
}
