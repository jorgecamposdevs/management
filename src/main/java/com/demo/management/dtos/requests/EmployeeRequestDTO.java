package com.demo.management.dtos.requests;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class EmployeeRequestDTO {

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String name;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String job;

    @DecimalMin(value = "1.0", message = "{minimum.value}")
    @DecimalMax(value = "100000.0", message = "{maximum.value}")
    private double salary;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String phone;

    @NotEmpty(message = "{not.empty}")
    @NotBlank(message = "{not.blank}")
    private String address;
}
