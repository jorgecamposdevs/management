package com.demo.management.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponseDTO {

    private String id;

    private String name;

    private String job;

    private double salary;

    private String phone;

    private String address;
}
