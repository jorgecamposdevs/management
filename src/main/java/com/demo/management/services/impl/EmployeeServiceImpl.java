package com.demo.management.services.impl;

import com.demo.management.entities.EmployeeEntity;
import com.demo.management.exceptions.EmployeeExceptions;
import com.demo.management.exceptions.enums.EmployeeEnum;
import com.demo.management.repositories.EmployeeRepository;
import com.demo.management.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeExceptions(EmployeeEnum.EMPLOYEE_NOT_FOUND));
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

    @Override
    public Optional<EmployeeEntity> findByName(String name) {
        log.info("get employee by name {}", name);
        return employeeRepository.findByName(name);
    }

    @Override
    public List<EmployeeEntity> findAll() {
        log.info("getting employees");
        return employeeRepository.findAll();
    }
}
