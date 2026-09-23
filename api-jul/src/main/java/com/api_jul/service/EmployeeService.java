package com.api_jul.service;

import com.api_jul.dto.EmployeeDto;
import com.api_jul.dto.EmployeeResponseDto;

public interface EmployeeService {

    EmployeeDto add(EmployeeDto employeeDto);
    public void deleteEmployee(long id);
    public EmployeeDto findEmployeeById(long id);
    public void updateEmployee(EmployeeDto employeeDto);
    public EmployeeResponseDto getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir);
}
