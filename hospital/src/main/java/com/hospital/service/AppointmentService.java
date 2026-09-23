package com.hospital.service;

import com.hospital.models.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    public List<Appointment> getAllAppointments(){

        try {
            System.out.println("into service layer");
            return null;
        }
        catch (Exception e){
            System.out.println("Error message:" + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id){
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment){
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id){
        try {

        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
        }
    }

    public Appointment updateAppointment(Long id){
        try {
            return null;
        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
            return null;
        }
    }
}
