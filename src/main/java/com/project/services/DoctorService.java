package com.project.services;

import com.project.models.Doctor;
import com.project.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // Return available slots
    public List<String> getAvailableSlots(
            Long doctorId,
            LocalDate date
    ) {

        Optional<Doctor> doctor =
                doctorRepository.findById(doctorId);

        return doctor.map(Doctor::getAvailableTimes)
                .orElse(List.of());
    }

    // Validate doctor login
    public Map<String, Object> validateDoctorLogin(
            String email,
            String password
    ) {

        Optional<Doctor> doctor =
                doctorRepository.findByEmail(email);

        if (doctor.isPresent()) {

            return Map.of(
                    "success", true,
                    "message", "Login successful",
                    "doctor", doctor.get()
            );
        }

        return Map.of(
                "success", false,
                "message", "Invalid credentials"
        );
    }
}
