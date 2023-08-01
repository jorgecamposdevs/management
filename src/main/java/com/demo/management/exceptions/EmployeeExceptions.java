package com.demo.management.exceptions;

import com.demo.management.exceptions.enums.EmployeeEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class EmployeeExceptions extends ManagementException {

    private static final long serialVersionUID = -4589179341768493322L;

    private EmployeeEnum error;

    public EmployeeExceptions(EmployeeEnum error) {
        super(error.getMessage());
        this.error = error;
    }
}
