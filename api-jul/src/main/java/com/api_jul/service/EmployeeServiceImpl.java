package com.api_jul.service;

import com.api_jul.dto.EmployeeDto;
import com.api_jul.dto.EmployeeResponseDto;
import com.api_jul.entity.Employee;
import com.api_jul.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeDto,emp);
        if(employeeRepository.existsByEmailId(employeeDto.getEmailId())){
            throw new RuntimeException("Email already exists");
        }
        if(employeeRepository.existsByMobile(employeeDto.getMobile())){
            throw new RuntimeException("Mobile already exists");
        }
        Employee saveEmployee = employeeRepository.save(emp);

        BeanUtils.copyProperties(saveEmployee,employeeDto);
        return employeeDto;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto findEmployeeById(long id) {
        Optional<Employee> opEmp = employeeRepository.findById(id);
        if(opEmp.isPresent()){
            Employee employee = opEmp.get();
            EmployeeDto dto = new EmployeeDto();
            BeanUtils.copyProperties(employee, dto);
            return dto;
        }else{
            throw new ArrayIndexOutOfBoundsException("no record found");
        }
    }

    @Override
    public void updateEmployee(EmployeeDto employeeDto) {

    }

    @Override
    public EmployeeResponseDto getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase("asc")?Sort.by(Sort.Direction.ASC,sortBy):Sort.by(Sort.Direction.DESC,sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> pageEmp = employeeRepository.findAll(pageable);
        List<Employee> employees = pageEmp.getContent();
        List<EmployeeDto> dtos = new ArrayList<>();
        for(Employee e:employees){
            EmployeeDto dto = new EmployeeDto();
            BeanUtils.copyProperties(e,dto);
            dtos.add(dto);
        }


        EmployeeResponseDto response = new EmployeeResponseDto();
        response.setContent(dtos);
        response.setPageNo(pageEmp.getNumber());
        response.setPageSize(pageEmp.getSize());
        response.setTotalElements(pageEmp.getTotalElements());
        response.setTotalPages(pageEmp.getTotalPages());
        response.setLast(pageEmp.isLast());

        return response;
    }

}


