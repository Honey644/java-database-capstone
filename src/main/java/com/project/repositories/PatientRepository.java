package com.project.repositories;

import com.project.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository
        extends JpaRepository<Patient, Long> {

    // Retrieve by email
    Optional<Patient> findByEmail(String email);

    // Retrieve by email OR phone number
    Optional<Patient> findByEmailOrPhoneNumber(
            String email,
            String phoneNumber
    );
}
