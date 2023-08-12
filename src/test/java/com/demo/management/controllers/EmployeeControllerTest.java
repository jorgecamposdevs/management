package com.demo.management.controllers;

import com.demo.management.dtos.responses.EmployeeResponseDTO;
import com.demo.management.entities.EmployeeEntity;
import com.demo.management.facades.EmployeeFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeFacade employeeFacade;

    private EmployeeResponseDTO employeeResponseDTO;

    private static final String ID = "1234567890";
    private static final String NAME = "Jorge";
    private static final String JOB = "developer";
    private static final Double SALARY = 6.9;
    private static final String PHONE = "99875-6666";
    private static final String ADDRESS = "Avenida Pacaembu 1878, ap 31 bl 04";
    private static final int INDEX = 0;

    @BeforeEach
    void setUp() {
        openMocks(this);
        returnObjectEmployee();
    }

    @Test
    void create() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    private void returnObjectEmployee() {
        employeeResponseDTO = new EmployeeResponseDTO(ID, NAME, JOB, SALARY, PHONE, ADDRESS);
    }
}