package com.demo.management.services.impl;

import com.demo.management.entities.EmployeeEntity;
import com.demo.management.exceptions.EmployeeExceptions;
import com.demo.management.exceptions.enums.EmployeeEnum;
import com.demo.management.repositories.EmployeeRepository;
import com.demo.management.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeEntity create(EmployeeEntity employeeEntity) {
        log.info("add new employees {}", employeeEntity);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity findById(String id) {
        log.info("get details of existing employees {}", id);
        EmployeeEntity employeeEntity =  employeeRepository.findById(id).orElse(new EmployeeEntity());

        if (employeeEntity.getId() == null) {
            throw new EmployeeExceptions(EmployeeEnum.EMPLOYEE_NOT_FOUND);
        }
        return employeeEntity;
    }

    @Override
    public EmployeeEntity update(EmployeeEntity employeeEntity, String id) {
        log.info("update existing employee details {}", employeeEntity);
        employeeEntity.setId(id);
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteById(String id) {
        log.info("delete existing employees {}", id);
        employeeRepository.deleteById(id);
    }
}
