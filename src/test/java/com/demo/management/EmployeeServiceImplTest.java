package com.demo.management;

import com.demo.management.entities.EmployeeEntity;
import com.demo.management.repositories.EmployeeRepository;
import com.demo.management.services.impl.EmployeeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Before
    public void setupMock() {
        MockitoAnnotations.openMocks(this);
        when(employeeRepository.save(returningEmployeeObject())).thenReturn(returningEmployeeObject());
        when(employeeRepository.findById("5229229292929922")).thenReturn(Optional.of(returningEmployeeObject()));
    }

    @Test
    public void saveWithSuccessReturnOk() throws Exception {
        assertEquals(returningEmployeeObject(), employeeService.create(returningEmployeeObject()));
    }

    @Test
    public void findByIdWithSuccessReturnOk() throws Exception {
        assertEquals(returningEmployeeObject(), employeeService.findById("5229229292929922"));
    }

    @Test
    public void updateWithSuccessReturnOk() throws Exception {
        assertEquals(returningEmployeeObject(), employeeService.update(returningEmployeeObject(), "5229229292929922"));
    }

    @Test
    public void deleteByIdWithSuccessReturnOK() throws Exception {
        employeeService.deleteById("5229229292929922");
        verify(employeeRepository).deleteById("5229229292929922");
    }

    private EmployeeEntity returningEmployeeObject() {
        return new EmployeeEntity("5229229292929922", "Jorge Campos", "developer", 7.000, "11 965899856", "av Cangaiba 2565");
    }
}
