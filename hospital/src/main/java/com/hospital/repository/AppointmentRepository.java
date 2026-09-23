package com.hospital.repository;

import com.hospital.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository<Appointment> extends JpaRepository<Appointment,Long> {
}
