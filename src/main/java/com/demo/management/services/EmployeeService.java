package com.demo.management.services;

import com.demo.management.entities.EmployeeEntity;

public interface EmployeeService {

    EmployeeEntity create(EmployeeEntity employeeEntity);
    EmployeeEntity findById(String id);
    EmployeeEntity update(EmployeeEntity employeeEntity, String id);
    void deleteById(String id);
}
