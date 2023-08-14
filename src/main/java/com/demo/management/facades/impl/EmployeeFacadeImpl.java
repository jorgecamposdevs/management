package com.demo.management.facades.impl;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;
import com.demo.management.entities.EmployeeEntity;
import com.demo.management.exceptions.EmployeeExceptions;
import com.demo.management.exceptions.enums.EmployeeEnum;
import com.demo.management.facades.EmployeeFacade;
import com.demo.management.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeFacadeImpl implements EmployeeFacade {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeResponseDTO create(EmployeeRequestDTO employeeRequestDTO) {
        checkIfNameExists(employeeRequestDTO.getName());
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
    public List<EmployeeResponseDTO> findAll() {
        List<EmployeeResponseDTO> list = new ArrayList<>();
        employeeService.findAll().forEach(employeeEntity -> list.add(toDto(employeeEntity)));
        return list;
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

    private void checkIfNameExists(String name) {
        Optional<EmployeeEntity> optional = employeeService.findByName(name);

        if (optional.isPresent()) {
            throw new EmployeeExceptions(EmployeeEnum.EMPLOYEE_ALREADY_EXIST);
        }
    }
}
