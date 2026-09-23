package com.webapp.controller;

import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

    public String view(){
        return "create";
    }
}
