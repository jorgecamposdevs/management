package com.demo.management.controllers;

import com.demo.management.dtos.requests.EmployeeRequestDTO;
import com.demo.management.dtos.responses.EmployeeResponseDTO;
import com.demo.management.facades.EmployeeFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeFacade employeeFacade;

    @Operation(summary = "creating new employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "creating new employees"),
            @ApiResponse(responseCode = "400", description = "bad request")
    })
    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new ResponseEntity<>(employeeFacade.create(employeeRequestDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "getting specific employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "getting specific employee successfully"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable String id) {
        return new ResponseEntity<>(employeeFacade.findById(id), HttpStatus.OK);
    }

    @Operation(summary = "updating employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updating employee successfully"),
            @ApiResponse(responseCode = "400", description = "bad request"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(@Valid @PathVariable String id,
                                                      @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        return new ResponseEntity<>(employeeFacade.update(employeeRequestDTO, id), HttpStatus.OK);
    }

    @Operation(summary = "deleting specific employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deleting specific employee successfully"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> deleteById(@PathVariable String id) {
        employeeFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "findAll employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "findAll employees successfully"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> findAll() {
        return new ResponseEntity<>(employeeFacade.findAll(), HttpStatus.OK);
    }
}
