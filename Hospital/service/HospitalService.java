package com.hospital.service;

import com.hospital.patient.Patient;
import com.hospital.exception.InvalidAgeException;
import com.hospital.exception.PatientNotFoundException;
import com.hospital.exception.DuplicatePatientException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HospitalService {
    private static final String FILE_NAME = "patients.txt";

    private List<Patient> loadPatients() throws IOException {
        List<Patient> patients = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return patients;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    patients.add(Patient.fromString(line));
                }
            }
        }
        return patients;
    }

    public void addPatient(Patient p) throws InvalidAgeException, DuplicatePatientException, IOException {
        if (p.getAge() < 0 || p.getAge() > 120) {
            throw new InvalidAgeException("Age must be between 0 and 120. Provided: " + p.getAge());
        }

        List<Patient> existing = loadPatients();
        for (Patient patient : existing) {
            if (patient.getPatientId() == p.getPatientId()) {
                throw new DuplicatePatientException("Patient with ID " + p.getPatientId() + " already exists.");
            }
        }

        if (p.getAge() > 60 && "Heart Problem".equalsIgnoreCase(p.getDisease())) {
            System.out.println("Priority Patient – Immediate Attention Required");
        }

        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(p.toString());
            bw.newLine();
        }
    }

    public Patient searchPatient(int patientId) throws PatientNotFoundException, IOException {
        List<Patient> patients = loadPatients();
        for (Patient p : patients) {
            if (p.getPatientId() == patientId) {
                return p;
            }
        }
        throw new PatientNotFoundException("Patient with ID " + patientId + " not found.");
    }

    public void displayPatients() throws IOException {
        List<Patient> patients = loadPatients();
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
        } else {
            for (Patient p : patients) {
                p.displayPatient();
            }
        }
    }
}
