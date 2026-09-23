package com.auth_service_jul.controller;


import com.auth_service_jul.dto.APIResponse;
import com.auth_service_jul.dto.LoginDto;
import com.auth_service_jul.dto.UserDto;
import com.auth_service_jul.repository.UserRepository;
import com.auth_service_jul.service.JwtService;
import com.auth_service_jul.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private UserService userService;

    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    public AuthController(UserService userService, UserRepository userRepository,AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/patient_signup")
    public ResponseEntity<APIResponse<String>> patientSignUp(@RequestBody UserDto userDto){
        APIResponse<String> response = new APIResponse<>();
        if(userRepository.existsByEmail(userDto.getEmail())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Email id already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepository.existsByUsername(userDto.getUsername())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Username already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        userDto.setRole("ROLE_PATIENT");
        userService.addUser(userDto);
        response.setMessage("Done");
        response.setStatus(201);
        response.setData(" Registration completed");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/doctor_signup")
    public ResponseEntity<APIResponse<String>> doctorSignUp(@RequestBody UserDto userDto){
        APIResponse<String> response = new APIResponse<>();
        if(userRepository.existsByEmail(userDto.getEmail())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Email id already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(userRepository.existsByUsername(userDto.getUsername())){
            response.setMessage("Error");
            response.setStatus(500);
            response.setData("Username already exists");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        userDto.setRole("ROLE_DOCTOR");
        userService.addUser(userDto);
        response.setMessage("Done");
        response.setStatus(201);
        response.setData(" Registration completed");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> login(@RequestBody LoginDto loginDto) {

        APIResponse<String> response = new APIResponse<>();
        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        if(authentication.isAuthenticated()){
            String token = jwtService.generateToken(loginDto.getUsername(),"ADMIN");
            response.setMessage("Login Sucessful");
            response.setStatus(200);
            response.setData(token);
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
        }
        response.setMessage("Login failed");
        response.setStatus(401);
        response.setData("Invalid credentials");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
