package com.project.zeft;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static void saveEntity(ArrayList<Doctor> doctorList, ArrayList<Patient> patientList, ArrayList<Receptionist> receptionistList, ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptions) {
        try (FileWriter writer = new FileWriter("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/doctors.txt")) {
            for (Doctor doctor : doctorList) {
                writer.write(doctor.toString() + "\n");
            }
            System.out.println("Doctor data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving doctor data: " + e.getMessage());
        }
        try (FileWriter writer = new FileWriter("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/patients.txt")) {
            for (Patient patient : patientList) {
                writer.write(patient.toString() + "\n");
            }
            System.out.println("Patient data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving patient data: " + e.getMessage());
        }
        try (FileWriter writer = new FileWriter("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/receptionists.txt")) {
            for (Receptionist receptionist : receptionistList) {
                writer.write(receptionist.toString() + "\n");
            }
            System.out.println("Receptionist data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving receptionist data: " + e.getMessage());
        }
        try (FileWriter writer = new FileWriter("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/appointments.txt")) {
            for (Appointment appointment : appointmentList) {
                writer.write(appointment.toString() + "\n");
            }
            System.out.println("Appointments saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving appointment data: " + e.getMessage());
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/Prescriptions.txt"))) {
            for (Prescription prescription : prescriptions) {
                writer.write(prescription.toString());
                writer.newLine();
            }
            System.out.println("Prescription data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving prescription data: " + e.getMessage());
        }
    }

    public static void loadEntity(ArrayList<Doctor> doctorList, ArrayList<Patient> patientList, ArrayList<Receptionist> receptionistList, ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptions) {

        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/doctors.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                doctorList.add(Doctor.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading doctor data: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                patientList.add(Patient.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading patient data: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/receptionists.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                receptionistList.add(Receptionist.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading receptionist data: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/appointments.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appointmentList.add(Appointment.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading appointment data: " + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("C:/Users/ahmed/IdeaProjects/Cmd_Clinic/src/Prescriptions.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                prescriptions.add(Prescription.fromString(line));
            }
        } catch (IOException e) {
            System.err.println("Error loading prescription data: " + e.getMessage());
        }
    }

}