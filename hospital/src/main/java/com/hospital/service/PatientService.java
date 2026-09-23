package com.hospital.service;

import com.hospital.models.Patient;
import com.hospital.repository.PatientRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);


    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        try {
            System.out.println("into service layer");
            return patientRepository.findAll();
        }
        catch (Exception e){
            System.out.println("Error message:" + e.getMessage());
            logger.error("An error occured while fetching all patient: {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id){
        try {
            logger.info("Fetching patient with id: {}", id);
            Optional<Patient> patient = patientRepository.findById(id);
            return patient.orElse(null);
        } catch (Exception e) {
            logger.error("An error occured while fetching patient by id {} : {}", id, e.getMessage(), e);
            return null;
        }
    }

    public Patient createPatient(Patient patient){
        try {
            patientRepository.save(patient);
            return patient;
        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id){
        try {
            patientRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
        }
    }

    public Patient updatePatient(Long id, Patient updatedPatient){
        try {
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if(existingPatient.isPresent()){
                Patient p = existingPatient.get();
                p.setName(updatedPatient.getName());
                p.setAge(updatedPatient.getAge());
                p.setGender(updatedPatient.getGender());
                patientRepository.save(p);
                return updatedPatient;
            }
            else{
                logger.error("Patient with id {} not found", id);
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error message:" + e.getMessage());
            return null;
        }
    }
}
