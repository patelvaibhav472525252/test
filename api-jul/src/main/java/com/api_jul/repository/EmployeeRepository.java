package com.api_jul.repository;

import com.api_jul.dto.EmployeeDto;
import com.api_jul.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    boolean existsByEmailId(String emailId);
    boolean existsByMobile(String mobile);

}