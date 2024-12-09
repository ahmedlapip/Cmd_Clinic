package OOP;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    // Save Doctors to File
    public static void saveDoctors(ArrayList<Doctor> doctorList) {
        try (FileWriter writer = new FileWriter("doctors.txt")) {
            for (Doctor doctor : doctorList) {
                writer.write(doctor.toString() + "\n");
            }
            System.out.println("Doctor data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving doctor data: " + e.getMessage());
        }
    }

    // Save Patients to File
    public static void savePatients(ArrayList<Patient> patientList) {
        try (FileWriter writer = new FileWriter("patients.txt")) {
            for (Patient patient : patientList) {
                writer.write(patient.toString() + "\n");
            }
            System.out.println("Patient data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving patient data: " + e.getMessage());
        }
    }

    // Save Receptionists to File
    public static void saveReceptionists(ArrayList<Receptionist> receptionistList) {
        try (FileWriter writer = new FileWriter("receptionists.txt")) {
            for (Receptionist receptionist : receptionistList) {
                writer.write(receptionist.toString() + "\n");
            }
            System.out.println("Receptionist data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving receptionist data: " + e.getMessage());
        }
    }

    // Save Appointments to File
    public static void saveAppointments(ArrayList<Appointment> appointmentList) {
        try (FileWriter writer = new FileWriter("appointments.txt")) {
            for (Appointment appointment : appointmentList) {
                writer.write(appointment.toString() + "\n");
            }
            System.out.println("Appointments saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving appointment data: " + e.getMessage());
        }
    }

    // Load Doctors from File
    public static ArrayList<Doctor> loadDoctors() {
        ArrayList<Doctor> doctorList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("doctors.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                doctorList.add(Doctor.fromString(line));
            }
            System.out.println("Doctor data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading doctor data: " + e.getMessage());
        }
        return doctorList;
    }

    // Load Patients from File
    public static ArrayList<Patient> loadPatients() {
        ArrayList<Patient> patientList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("patients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                patientList.add(Patient.fromString(line));
            }
            System.out.println("Patient data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading patient data: " + e.getMessage());
        }
        return patientList;
    }

    // Load Receptionists from File
    public static ArrayList<Receptionist> loadReceptionists() {
        ArrayList<Receptionist> receptionistList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("receptionists.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                receptionistList.add(Receptionist.fromString(line));
            }
            System.out.println("Receptionist data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading receptionist data: " + e.getMessage());
        }
        return receptionistList;
    }

    // Load Appointments from File
    public static ArrayList<Appointment> loadAppointments() {
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("appointments.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appointmentList.add(Appointment.fromString(line));
            }
            System.out.println("Appointments loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error loading appointment data: " + e.getMessage());
        }
        return appointmentList;
    }
}
