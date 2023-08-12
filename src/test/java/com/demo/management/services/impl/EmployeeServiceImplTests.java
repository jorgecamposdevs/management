package com.demo.management.services.impl;

import com.demo.management.entities.EmployeeEntity;
import com.demo.management.repositories.EmployeeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTests {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeEntity employeeEntity;

    private Optional<EmployeeEntity> optionalEmployeeEntity;

    private static final String ID = "1234567890";
    private static final String NAME = "Jorge";
    private static final String JOB = "developer";
    private static final Double SALARY = 6.9;
    private static final String PHONE = "99875-6666";
    private static final String ADDRESS = "Avenida Pacaembu 1878, ap 31 bl 04";


    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        returnObjectEmployeeEntity();
    }

    @Test
    public void createSuccessReturnOk() throws Exception {
        Mockito.when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
        EmployeeEntity resultTests = employeeService.create(employeeEntity);
        Assert.assertNotNull(resultTests);
        Assert.assertEquals(EmployeeEntity.class, resultTests.getClass());
    }

    @Test
    public void findByIdSuccessReturnOk() throws Exception {
        Mockito.when(employeeRepository.findById(ID)).thenReturn(Optional.of(employeeEntity));
        EmployeeEntity resultTests = employeeService.findById(ID);
        Assert.assertNotNull(resultTests);
        Assert.assertEquals(EmployeeEntity.class, resultTests.getClass());
    }

    @Test
    public void updateByIdSuccessReturnOk() throws Exception {
        Mockito.when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
        EmployeeEntity resultTests = employeeService.update(employeeEntity, ID);
        employeeEntity.setId(ID);
        Assert.assertNotNull(resultTests);
        Assert.assertEquals(EmployeeEntity.class, resultTests.getClass());
    }

    @Test
    public void deleteByIdSuccessReturnOk() throws Exception {
        Mockito.doNothing().when(employeeRepository).deleteById(Mockito.anyString());
        employeeService.deleteById(ID);
        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(Mockito.anyString());
    }

    @Test
    public void findByNameSuccessReturnOk() {
        Mockito.when(employeeRepository.findByName(NAME)).thenReturn(optionalEmployeeEntity);
        Optional<EmployeeEntity> optional = employeeService.findByName(NAME);
        Mockito.verify(employeeRepository, Mockito.times(1)).findByName(NAME);
        Assert.assertTrue(optional.isPresent());
        Assert.assertEquals(NAME, optional.get().getName());
    }

    private void returnObjectEmployeeEntity() {
        employeeEntity = new EmployeeEntity(ID, NAME, JOB, SALARY, PHONE, ADDRESS);
        optionalEmployeeEntity = Optional.of(new EmployeeEntity(ID, NAME, JOB, SALARY, PHONE, ADDRESS));
    }
}
