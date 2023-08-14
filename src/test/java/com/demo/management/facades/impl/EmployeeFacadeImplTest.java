package com.demo.management.facades.impl;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;
import com.demo.management.entities.EmployeeEntity;
import com.demo.management.exceptions.EmployeeExceptions;
import com.demo.management.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeFacadeImplTest {

    @InjectMocks
    private EmployeeFacadeImpl employeeFacade;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private ModelMapper modelMapper;

    private EmployeeEntity employeeEntity;

    private Optional<EmployeeEntity> optionalEmployeeEntity;


    private EmployeeRequestDTO employeeRequestDTO;

    private EmployeeResponseDTO employeeResponseDTO;

    private static final String ID = "1234567890";
    private static final String NAME = "Jorge";
    private static final String JOB = "developer";
    private static final Double SALARY = 6.9;
    private static final String PHONE = "99875-6666";
    private static final String ADDRESS = "Avenida Pacaembu 1878, ap 31 bl 04";

    private static final int INDEX = 0;

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        returnEmployeeRequestDTO();
        returnEmployeeResponseDTO();
        returnEmployeeEntity();
        returnOptionalEmployeeEntity();
    }

    @Test
    public void whenCreateThenReturnSuccessOk() {
        when(employeeService.create(any())).thenReturn(employeeEntity);
        when(modelMapper.map(returnEmployeeEntity(), EmployeeResponseDTO.class)).thenReturn(returnEmployeeResponseDTO());
        when(modelMapper.map(returnEmployeeRequestDTO(), EmployeeEntity.class)).thenReturn(returnEmployeeEntity());

        EmployeeResponseDTO responseDTO = employeeFacade.create(employeeRequestDTO);

        assertNotNull(responseDTO);
        assertEquals(EmployeeResponseDTO.class, responseDTO.getClass());
        assertEquals(ID, responseDTO.getId());
        assertEquals(NAME, responseDTO.getName());
        assertEquals(JOB, responseDTO.getJob());
        assertEquals(PHONE, responseDTO.getPhone());
        assertEquals(ADDRESS, responseDTO.getAddress());
    }

    @Test
    public void whenCreateThenReturnException() throws Exception {
        when(employeeService.findByName(anyString())).thenReturn(optionalEmployeeEntity);
        when(modelMapper.map(returnEmployeeEntity(), EmployeeResponseDTO.class)).thenReturn(returnEmployeeResponseDTO());
        when(modelMapper.map(returnEmployeeRequestDTO(), EmployeeEntity.class)).thenReturn(returnEmployeeEntity());

        try {
            employeeFacade.create(employeeRequestDTO);
        } catch (Exception e) {
            assertEquals(EmployeeExceptions.class, e.getClass());
            assertEquals("employee already exist", e.getMessage());
        }
    }

    @Test
    public void whenFindByIdThenSuccessReturnOk() throws Exception {
        when(employeeService.findById(ID)).thenReturn(returnEmployeeEntity());
        when(modelMapper.map(returnEmployeeEntity(), EmployeeResponseDTO.class)).thenReturn(returnEmployeeResponseDTO());
        when(modelMapper.map(returnEmployeeRequestDTO(), EmployeeEntity.class)).thenReturn(returnEmployeeEntity());

        EmployeeResponseDTO responseDTO = employeeFacade.findById(ID);

        assertNotNull(responseDTO);
        assertEquals(EmployeeResponseDTO.class, responseDTO.getClass());
        assertEquals(ID, responseDTO.getId());
        assertEquals(NAME, responseDTO.getName());
        assertEquals(JOB, responseDTO.getJob());
        assertEquals(PHONE, responseDTO.getPhone());
        assertEquals(ADDRESS, responseDTO.getAddress());
    }

    @Test
    public void whenUpdateThenReturnSuccessOk() {
        when(employeeService.update(returnEmployeeEntity(), ID)).thenReturn(returnEmployeeEntity());
        when(modelMapper.map(returnEmployeeEntity(), EmployeeResponseDTO.class)).thenReturn(returnEmployeeResponseDTO());
        when(modelMapper.map(returnEmployeeRequestDTO(), EmployeeEntity.class)).thenReturn(returnEmployeeEntity());

        EmployeeResponseDTO responseDTO = employeeFacade.update(employeeRequestDTO, ID);

        assertNotNull(responseDTO);
        assertEquals(EmployeeResponseDTO.class, responseDTO.getClass());
        assertEquals(ID, responseDTO.getId());
        assertEquals(NAME, responseDTO.getName());
        assertEquals(JOB, responseDTO.getJob());
        assertEquals(PHONE, responseDTO.getPhone());
        assertEquals(ADDRESS, responseDTO.getAddress());
    }

    @Test
    public void whenFindAllThenReturnSuccessOk() {
        when(employeeService.findAll()).thenReturn(List.of(employeeEntity));
        when(modelMapper.map(returnEmployeeEntity(), EmployeeResponseDTO.class)).thenReturn(returnEmployeeResponseDTO());
        when(modelMapper.map(returnEmployeeRequestDTO(), EmployeeEntity.class)).thenReturn(returnEmployeeEntity());

        List<EmployeeResponseDTO> list = employeeFacade.findAll();

        assertNotNull(list);
        assertEquals(EmployeeResponseDTO.class, list.get(INDEX).getClass());
        assertEquals(ID, list.get(INDEX).getId());
        assertEquals(NAME, list.get(INDEX).getName());
        assertEquals(JOB, list.get(INDEX).getJob());
        assertEquals(PHONE, list.get(INDEX).getPhone());
        assertEquals(ADDRESS, list.get(INDEX).getAddress());
    }

    @Test
    public void whenDeleteByIdThenSuccessReturnOk() {
        doNothing().when(employeeService).deleteById(anyString());
        employeeService.deleteById(ID);
        verify(employeeService, times(1)).deleteById(anyString());
    }

    private EmployeeRequestDTO returnEmployeeRequestDTO() {
       employeeRequestDTO = new EmployeeRequestDTO(NAME, JOB, SALARY, PHONE, ADDRESS);
       return employeeRequestDTO;
    }

    private EmployeeResponseDTO returnEmployeeResponseDTO() {
        employeeResponseDTO = new EmployeeResponseDTO(ID, NAME, JOB, SALARY, PHONE, ADDRESS);
        return employeeResponseDTO;
    }

    private EmployeeEntity returnEmployeeEntity() {
        employeeEntity = new EmployeeEntity(ID, NAME, JOB, SALARY, PHONE, ADDRESS);
        return employeeEntity;
    }

    private Optional<EmployeeEntity> returnOptionalEmployeeEntity() {
        optionalEmployeeEntity = Optional.of(new EmployeeEntity(ID, NAME, JOB, SALARY, PHONE, ADDRESS));
        return optionalEmployeeEntity;
    }
}
