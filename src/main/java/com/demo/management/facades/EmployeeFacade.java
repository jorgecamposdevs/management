package com.demo.management.facades;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeFacade {

    EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO findById(String id);
    EmployeeResponseDTO update(EmployeeRequestDTO employeeRequestDTO, String id);

    List<EmployeeResponseDTO> findAll();
    void deleteById(String id);
}
