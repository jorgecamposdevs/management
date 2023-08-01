package com.demo.management.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum EmployeeEnum {

    EMPLOYEE_NOT_FOUND("EMPLOYEE_NOT_FOUND", "employee not found", 404),
    EMPLOYEE_ALREADY_EXIST("EMPLOYEE_ALREADY_EXIST", "employee already exist", 400);

    private String code;
    private String message;
    private Integer statusCode;
}
