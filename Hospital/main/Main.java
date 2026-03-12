package com.hospital.main;

import com.hospital.patient.Patient;
import com.hospital.service.HospitalService;
import com.hospital.exception.InvalidAgeException;
import com.hospital.exception.PatientNotFoundException;
import com.hospital.exception.DuplicatePatientException;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalService service = new HospitalService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Hospital Patient Record System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search Patient by ID");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addPatient(scanner, service);
                    break;
                case 2:
                    displayAllPatients(service);
                    break;
                case 3:
                    searchPatient(scanner, service);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addPatient(Scanner scanner, HospitalService service) {
        try {
            System.out.print("Enter Patient ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Disease: ");
            String disease = scanner.nextLine();

            Patient p = new Patient(id, name, age, disease);
            service.addPatient(p);
            System.out.println("Patient added successfully.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter correct values.");
        } catch (InvalidAgeException | DuplicatePatientException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }

    private static void displayAllPatients(HospitalService service) {
        try {
            service.displayPatients();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void searchPatient(Scanner scanner, HospitalService service) {
        try {
            System.out.print("Enter Patient ID to search: ");
            int id = Integer.parseInt(scanner.nextLine());

            Patient p = service.searchPatient(id);
            System.out.println("Patient found:");
            p.displayPatient();

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        } catch (PatientNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
