package com.hospital.repository;

import com.hospital.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository<Doctor> extends JpaRepository<Doctor,Long> {
}
