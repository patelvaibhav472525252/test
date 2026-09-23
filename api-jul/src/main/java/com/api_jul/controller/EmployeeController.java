package com.api_jul.controller;

import com.api_jul.dto.APIResponse;
import com.api_jul.dto.EmployeeDto;
import com.api_jul.dto.EmployeeResponseDto;
import com.api_jul.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse<?>> saveEmployee(
            @Valid @RequestBody EmployeeDto employeeDto,
            BindingResult result
    ){
        EmployeeDto emp = employeeService.add(employeeDto);


        if(result.hasErrors()){
            APIResponse<String> response = new APIResponse<>();
            String message = result.getFieldError().getDefaultMessage();
            response.setData(message);
            response.setStatus(500);
            response.setMassage("error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(emp != null){
            APIResponse<EmployeeDto> response = new APIResponse<>();
            response.setMassage("created");
            response.setStatus(201);
            response.setData(emp);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else{
            APIResponse<EmployeeDto> response = new APIResponse<>();
            response.setMassage("something went wrong");
            response.setStatus(500);
            response.setData(emp);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteEmployee(
            @RequestParam long id
    ){
        employeeService.deleteEmployee(id);
        APIResponse<String> response = new APIResponse<>();
        response.setMassage("deleted");
        response.setStatus(200);
        response.setData("p d f d");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<EmployeeDto>> getEmployeeById(
            @PathVariable long id
    ){
        EmployeeDto employeeDto = employeeService.findEmployeeById(id);
        APIResponse<EmployeeDto> response = new APIResponse<>();
        response.setMassage("fetched");
        response.setStatus(200);
        response.setData(employeeDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<APIResponse<?>> getAllEmployees(

            @RequestParam(name= "pageNo",defaultValue = "0", required = false)int pageNo,
            @RequestParam(name= "pageSize",defaultValue = "2", required = false)int pageSize,
            @RequestParam(name= "sortBy",defaultValue = "id", required = false)String sortBy,
            @RequestParam(name= "sortDir",defaultValue = "asc", required = false)String sortDir
            ){
        EmployeeResponseDto employeeResponseDto = employeeService.getAllEmployees(pageNo,pageSize,sortBy,sortDir);
        APIResponse<EmployeeResponseDto> response = new APIResponse<>();
        response.setMassage("fetched");
        response.setStatus(200);
        response.setData(employeeResponseDto);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
