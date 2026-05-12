# Smart Clinic Database Schema

## Tables

### doctors
- id
- name
- specialization
- email
- phone_number

### patients
- id
- name
- email
- phone_number

### appointments
- id
- doctor_id
- patient_id
- appointment_time
- status

### prescriptions
- id
- doctor_id
- patient_id
- medicine
- dosage

## Relationships
- One doctor can have many appointments.
- One patient can book many appointments.
- One doctor can create many prescriptions.
