package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    private final Scanner scanner = new Scanner(System.in);

    public void out(Patient[] patients) {
        System.out.println("Patients loaded:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    // Validate Doctor's login credentials
    public void validateDoctor(String username, String password, ArrayList<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
               System.out.println("Doctor logged in successfully!");
                return ;
            }
            else {
                System.out.println("Invalid credentials. Please check your username and password for Doctor login.");
            }
        }

    }

    // Validate Patient's login credentials
    public void validatePatient( ArrayList<Patient> patients,ArrayList<Doctor> doctors,ArrayList<Appointment> appointmentList) {
        System.out.println("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.println("Enter password: ");
        String password = scanner.nextLine().trim();
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                System.out.println("Patient logged in successfully!");
                patient.patientMenu(doctors,appointmentList);
                return;
            }
            else {
                System.out.println("Invalid credentials. Please check your username and password for Patient login.");
            }
        }

    }

    // Validate Receptionist's login credentials
    public void validateReceptionist(String username, String password, ArrayList<Receptionist> receptionists) {
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
               System.out.println("Receptionist logged in successfully!");
                return;
            }
            else {
                System.out.println("Invalid credentials. Please check your username and password for Receptionist login.");
            }
        }

    }

    public void logIn(ArrayList<Doctor> doctors, ArrayList<Patient> patients, ArrayList<Receptionist> receptionists,ArrayList<Appointment> appointmentList) {
        System.out.println("[1] Login As A Doctor \n[2] Login As A Patient \n[3] Login As A Receptionist");
        System.out.print("Choose login type: ");

        // Ensure valid numeric choice
        int choice = getValidIntegerInput();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        switch (choice) {
            case 1 -> {
             validateDoctor(username, password, doctors);
            }
            case 2 -> {
                validatePatient( patients,doctors,appointmentList);

            }
            case 3 -> {
               validateReceptionist(username, password, receptionists);

            }
            default -> System.out.println("Invalid choice. Please select between 1, 2, or 3.");
        }
    }

    private int getValidIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
