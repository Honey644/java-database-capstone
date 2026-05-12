package com.project.controllers;

import com.project.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/availability")
    public ResponseEntity<?> getDoctorAvailability(
            @RequestHeader("Authorization") String token,
            @RequestParam Long doctorId,
            @RequestParam String date
    ) {

        if (token == null || token.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", "Invalid token"));
        }

        return ResponseEntity.ok(
                Map.of(
                        "doctorId", doctorId,
                        "date", date,
                        "availableSlots",
                        doctorService.getAvailableSlots(
                                doctorId,
                                LocalDate.parse(date)
                        )
                )
        );
    }
}
