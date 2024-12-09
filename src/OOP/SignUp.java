package OOP;

import java.util.ArrayList;
import java.util.Scanner;

class SignUp extends User {
    private final Scanner scanner = new Scanner(System.in);
    private final Login loginSystem = new Login();

    public void signUp(ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Receptionist> receptionists,ArrayList<Appointment> app) {
        System.out.println("Welcome to the Dental Clinic. Do you want to Login or Signup?");
        System.out.println("[1] SignUp \n[2] Login");
        System.out.print("Enter Your choice: ");

        int logOrSign = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (logOrSign == 1) {
            System.out.print("signUp As (doctor/patient/receptionist): ");
            String userType = scanner.nextLine().trim().toLowerCase();

            switch (userType) {
                case "doctor" -> registerDoctor(doctors);
                case "patient" -> registerPatient(patients);
                case "receptionist" -> registerReceptionist(receptionists);
                default -> System.out.println("Invalid selection. Please enter 'doctor', 'patient', or 'receptionist'.");
            }
        } else if (logOrSign == 2) {
            loginSystem.logIn(doctors, patients, receptionists,app);
        } else {
            System.out.println("Invalid choice. Please enter 1 for SignUp or 2 for Login.");
        }
    }

    private void registerDoctor(ArrayList<Doctor> doctors) {
        System.out.println("Registering as Doctor:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = input("Email: ");
        String password = input("Password: ");
        String mobileNumber = input("Mobile Number: ");
        String specialization = input("Speciality: ");


        Doctor doctor = new Doctor(firstname,lastname,username,email,password,mobileNumber,specialization);
        doctors.add(doctor);
        System.out.println("Successfully Signed Up As A Doctor.");
    }

    private void registerPatient(ArrayList<Patient> patients) {
        System.out.println("Registering as Patient:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = input("Email: ");
        String password = input("Password: ");
        String mobileNumber = input("Mobile Number: ");
        String patientHistory = input("Patient History: ");
        String bloodType = input("Blood Type: ").toUpperCase();
        String gender = input("Gender: ");
        String age = input("Age: ");
        float weight = inputFloat("Weight (KG): ");
        float height = inputFloat("Height (cm): ");

        Patient patient = new Patient(firstname, lastname, username, password, email, mobileNumber, patientHistory, bloodType, gender, age, weight, height);
        patients.add(patient);
        System.out.println("Successfully Signed Up As A Patient.");
    }

    private void registerReceptionist(ArrayList<Receptionist> receptionists) {
        System.out.println("Registering as Receptionist:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = input("Email: ");
        String password = input("Password: ");
        String mobileNumber = input("Mobile Number: ");
        String gender = input("Gender: ");
        int age = inputInt("Age: ");

        Receptionist receptionist = new Receptionist(firstname, lastname, username, password, email, mobileNumber, gender, age);
        receptionists.add(receptionist);
        System.out.println("Successfully Signed Up As A Receptionist.");
    }


}
