package com.hospital.service;

import com.hospital.models.Doctor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    public List<Doctor> getAllDoctors(){

        try{
            System.out.println("into service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id){
        try{
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor){
        try{
            return null;
        } catch (Exception e) {
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id){
        try{

        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
        }
    }

    public Doctor updateDoctor(Long id){
        try{
            return null;
        }
        catch (Exception e){
            System.out.println("Error message" + e.getMessage());
            return null;
        }
    }
}
