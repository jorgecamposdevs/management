package com.demo.management.services.impl;

import com.demo.management.entities.EmployeeEntity;
import com.demo.management.exceptions.EmployeeExceptions;
import com.demo.management.exceptions.enums.EmployeeEnum;
import com.demo.management.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTests {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeEntity employeeEntity;

    private Optional<EmployeeEntity> optionalEmployeeEntity;

    private List<EmployeeEntity> employeeEntityList;

    private static final String ID = "1234567890";
    private static final String NAME = "Jorge";
    private static final String JOB = "developer";
    private static final Double SALARY = 6.9;
    private static final String PHONE = "99875-6666";
    private static final String ADDRESS = "Avenida Pacaembu 1878, ap 31 bl 04";

    private static final int INDEX = 0;


    @Before
    public void setupMock() {
        openMocks(this);
        returnObjectEmployeeEntity();
    }

    @Test
    public void createSuccessReturnOk() throws Exception {
        when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
        EmployeeEntity resultTests = employeeService.create(employeeEntity);
        assertNotNull(resultTests);
        assertEquals(EmployeeEntity.class, resultTests.getClass());
    }

    @Test
    public void findByIdSuccessReturnOk() throws Exception {
        when(employeeRepository.findById(ID)).thenReturn(Optional.of(employeeEntity));
        EmployeeEntity resultTests = employeeService.findById(ID);
        assertNotNull(resultTests);
        assertEquals(EmployeeEntity.class, resultTests.getClass());
    }

    @Test
    public void findByIdObjectNotFoundException() throws Exception {
        when(employeeRepository.findById(anyString())).thenThrow(new EmployeeExceptions(EmployeeEnum.EMPLOYEE_NOT_FOUND));

        try {
            employeeService.findById(ID);
        } catch (Exception e) {
            assertEquals(EmployeeExceptions.class, e.getClass());
            assertEquals("employee not found", e.getMessage());
        }
    }

    @Test
    public void updateByIdSuccessReturnOk() throws Exception {
        when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
        EmployeeEntity resultTests = employeeService.update(employeeEntity, ID);
        employeeEntity.setId(ID);
        assertNotNull(resultTests);
        assertEquals(EmployeeEntity.class, resultTests.getClass());
    }

    @Test
    public void deleteByIdSuccessReturnOk() throws Exception {
        doNothing().when(employeeRepository).deleteById(Mockito.anyString());
        employeeService.deleteById(ID);
        verify(employeeRepository, Mockito.times(1)).deleteById(Mockito.anyString());
    }

    @Test
    public void findByNameSuccessReturnOk() {
        when(employeeRepository.findByName(NAME)).thenReturn(optionalEmployeeEntity);
        Optional<EmployeeEntity> optional = employeeService.findByName(NAME);
        verify(employeeRepository, Mockito.times(1)).findByName(NAME);
        assertTrue(optional.isPresent());
        assertEquals(NAME, optional.get().getName());
    }

    @Test
    public void findAllSuccessReturnOk() throws Exception {
        when(employeeRepository.findAll()).thenReturn(List.of(employeeEntity));
        List<EmployeeEntity> list = employeeService.findAll();
        assertNotNull(list);
        assertEquals(EmployeeEntity.class, list.get(INDEX).getClass());
        assertEquals(ID, list.get(INDEX).getId());
        assertEquals(NAME, list.get(INDEX).getName());
        assertEquals(JOB, list.get(INDEX).getJob());
        assertEquals(PHONE, list.get(INDEX).getPhone());
        assertEquals(ADDRESS, list.get(INDEX).getAddress());
    }

    private void returnObjectEmployeeEntity() {
        employeeEntity = new EmployeeEntity(ID, NAME, JOB, SALARY, PHONE, ADDRESS);
        optionalEmployeeEntity = Optional.of(new EmployeeEntity(ID, NAME, JOB, SALARY, PHONE, ADDRESS));
    }
}
