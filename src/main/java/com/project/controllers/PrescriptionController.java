package com.project.controllers;

import com.project.models.Prescription;
import com.project.repositories.PrescriptionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @PostMapping
    public ResponseEntity<?> savePrescription(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody Prescription prescription
    ) {

        if (token == null || token.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of(
                            "message",
                            "Invalid token"
                    ));
        }

        Prescription savedPrescription =
                prescriptionRepository.save(prescription);

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "Prescription saved successfully",
                        "data",
                        savedPrescription
                )
        );
    }
}
