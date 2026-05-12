package com.project.services;

import com.project.models.Appointment;
import com.project.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Booking method
    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    // Retrieve appointments for doctor on specific date
    public List<Appointment> getAppointmentsByDoctorAndDate(
            Long doctorId,
            LocalDate date
    ) {
        return appointmentRepository
                .findByDoctorIdAndAppointmentDate(
                        doctorId,
                        date
                );
    }
}
