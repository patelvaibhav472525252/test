package com.ems1.service;

import com.ems1.Employee;
import com.ems1.dto.EmployeeDto;
import com.ems1.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{



    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void saveEmployee(EmployeeDto employeeDto) {

        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeDto, emp);
        employeeRepository.save(emp);
    }
}
