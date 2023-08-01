package com.demo.management.facades.impl;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;
import com.demo.management.entities.EmployeeEntity;
import com.demo.management.facades.EmployeeFacade;
import com.demo.management.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO) {
        return toDto(employeeService.create(toEntity(employeeRequestDTO)));
    }

    @Override
    public EmployeeResponseDTO findById(String id) {
        return toDto(employeeService.findById(id));
    }

    @Override
    public EmployeeResponseDTO update(EmployeeRequestDTO employeeRequestDTO, String id) {
        return toDto(employeeService.update(toEntity(employeeRequestDTO), id));
    }

    @Override
    public void deleteById(String id) {
        employeeService.deleteById(id);

    }

    public EmployeeResponseDTO toDto(EmployeeEntity employeeEntity) {
        return modelMapper.map(employeeEntity, EmployeeResponseDTO.class);
    }

    public EmployeeEntity toEntity(EmployeeRequestDTO employeeRequestDTO) {
        return modelMapper.map(employeeRequestDTO, EmployeeEntity.class);
    }
}