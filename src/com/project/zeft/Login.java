package com.project.zeft;

import java.util.ArrayList;

public class Login extends User {

    public void out(Patient[] patients) {
        System.out.println("Patients loaded:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void validateDoctor(String username, String password, ArrayList<Appointment> appointmentList,
                               ArrayList<Receptionist> receptionistList, ArrayList<Patient> patientList, ArrayList<Doctor> doctorList, ArrayList<Prescription> prescriptionList) {
        pause(1000);
        clear();
        boolean f = false;
        for (Doctor doctor : doctorList) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                System.out.println("Welcome back Dr." + doctor.getUsername());
                doctor.doctorMenu(appointmentList, receptionistList, patientList, prescriptionList);
                f = true;
            }
        }
        if (!f)
            System.out.println("Invalid credentials. Please check your username or password.");
    }

    public void validatePatient(String username, String password, ArrayList<Patient> patients
            , ArrayList<Doctor> doctors, ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptionList) {
        pause(1000);
        clear();
        boolean f = false;
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                System.out.println("Welcome " + patient.getUsername());
                patient.patientMenu(doctors, appointmentList, prescriptionList);
                f = true;
            }
        }
        if (!f)
            System.out.println("Invalid credentials. Please check your username or password.");
    }

    public void validateReceptionist(String username, String password, ArrayList<Receptionist> receptionists,
                                     ArrayList<Appointment> appointmentList, ArrayList<Patient> patientList) {
        pause(1000);
        clear();
        boolean f = false;
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
                System.out.println("Receptionist logged in successfully!");
                receptionist.receptionistMenu(appointmentList, patientList);
                f = true;
            }
        }
        if (!f)
            System.out.println("Invalid credentials. Please check your username and password for Receptionist login.");
    }

    public void logIn(ArrayList<Doctor> doctors, ArrayList<Patient> patients,
                      ArrayList<Receptionist> receptionists, ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptionList) {
        System.out.println("[1] Login As A Doctor \n[2] Login As A Patient \n[3] Login As A Receptionist");
        boolean Fault_log = false;
        do {
            int choice = inputInt("Enter your choice: ");
            pause(1000);
            clear();
            String username = input("Enter username: ");
            String password = input("Enter Password: ");
            switch (choice) {
                case 1 ->
                        validateDoctor(username, password, appointmentList, receptionists, patients, doctors, prescriptionList);
                case 2 -> validatePatient(username, password, patients, doctors, appointmentList, prescriptionList);
                case 3 -> validateReceptionist(username, password, receptionists, appointmentList, patients);
                default -> {
                    System.out.println("Invalid choice. Please select between 1, 2, or 3.");
                    Fault_log = true;
                }
            }
        } while (Fault_log);
    }

}