package com.demo.management;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;
import com.demo.management.entities.EmployeeEntity;
import com.demo.management.facades.impl.EmployeeFacadeImpl;
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeFacadeImplTest {

    @InjectMocks
    private EmployeeFacadeImpl employeeFacade;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private EmployeeService employeeService;

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        when(employeeService.create(returnObjectEmployeeEntity())).thenReturn(returnObjectEmployeeEntity());
        when(employeeService.findById("5229229292929922")).thenReturn(returnObjectEmployeeEntity());

        /* Converter ENTIDADE para DTO */
        when(employeeFacade.toDto(returnObjectEmployeeEntity())).thenReturn(returnObjectEmployeeResponseDTO());

        /* Converter DTO para ENTIDADE */
        when(employeeFacade.toEntity(returnObjectEmployeeRequestDTO())).thenReturn(returnObjectEmployeeEntity());
    }

    @Test
    public void saveWithSuccessReturnOk() throws Exception {
        assertEquals(returnObjectEmployeeResponseDTO(), employeeFacade.create(returnObjectEmployeeRequestDTO()));
    }

    @Test
    public void findByIdWithSuccessReturnOk() {
        assertEquals(returnObjectEmployeeResponseDTO(), employeeFacade.findById("5229229292929922"));
    }

    @Test
    public void deleteByIdWithSuccessReturnOK() {
        employeeFacade.deleteById("5229229292929922");
    }

    private EmployeeEntity returnObjectEmployeeEntity() {
        return new EmployeeEntity("5229229292929922", "Jorge Campos", "developer", 7.000, "11 965899856", "av Cangaiba 2565");
    }

    private EmployeeResponseDTO returnObjectEmployeeResponseDTO() {
        return new EmployeeResponseDTO("5229229292929922", "Jorge Campos", "developer", 7.000, "11 965899856", "av Cangaiba 2565");
    }

    private EmployeeRequestDTO returnObjectEmployeeRequestDTO() {
        return new EmployeeRequestDTO("Jorge Campos", "developer", 7.000, "11 965899856", "av Cangaiba 2565");
    }
}
