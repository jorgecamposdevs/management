package com.demo.management.facades;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;

public interface EmployeeFacade {

    EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO);
    EmployeeResponseDTO findById(String id);
    EmployeeResponseDTO update(EmployeeRequestDTO employeeRequestDTO, String id);
    void deleteById(String id);
}
