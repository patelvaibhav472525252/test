package com.ems1.controller;

import com.ems1.dto.EmployeeDto;
import com.ems1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    handler methods
    @RequestMapping("/view")
    public String viewPage(){
        return "registration";
    }
    @RequestMapping("/save")
    public String savePage(
            @RequestParam("name") String name,
            @RequestParam String email,
            @RequestParam String mobile,
            ModelMap model
    ){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(name);
        employeeDto.setEmail(email);
        employeeDto.setMobile(mobile);

        model.addAttribute("msg","employee is added");


        employeeService.saveEmployee(employeeDto);
        return "registration";
    }
}
