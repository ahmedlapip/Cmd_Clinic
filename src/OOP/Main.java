package OOP;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
    static ArrayList<Doctor> doctorList;
    static ArrayList<Patient> patientList;
    static ArrayList<Receptionist> receptionistList;

    public static void main(String[] args) throws IOException {

//        doctorList = FileHandler.loadDoctors();
        patientList = FileHandler.loadPatients();
        receptionistList = FileHandler.loadReceptionists();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nSaving data before exit...");
//            FileHandler.saveDoctors(doctorList);
            FileHandler.savePatients(patientList);
            FileHandler.saveReceptionists(receptionistList);
        }));

        Login loginSystem = new Login(doctorList, patientList, receptionistList);

        loginSystem.out();

        String firstname, lastname, username, password, email, age, mobilenumber, availableDays,  availableHours, patientHistory,  bloodType;
        float weight;
        float height;
        System.out.println("Welcome to the Dental Clinic. Do you want to Login or Signup?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("[1] SignUp \n[2] Login");
        System.out.print("Enter Your choice: ");
        int Enter = scanner.nextInt();

        if (Enter == 1)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("select (doctor/patient/receptionist):");
            System.out.print("Enter Your Choice: ");
            String userType = input.nextLine().toLowerCase();

            switch (userType) {
                case "doctor" -> {
                    System.out.print("First Name: ");
                    firstname = input.nextLine();
                    System.out.print("Last Name: ");
                    lastname = input.nextLine();
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Email: ");
                    email = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Mobile Number: ");
                    mobilenumber = input.nextLine();
                    System.out.print("Available Days: ");
                    availableDays = input.nextLine();
                    System.out.print("Available Hours: ");
                    availableHours = input.nextLine();
                    new SignUp(firstname, lastname, username, email, password, mobilenumber, availableDays, availableHours, doctorList);
                    System.out.println("Successfully Signed Up As A Doctor");

                }
                case "patient" -> {
                    System.out.print("First Name: ");
                    firstname = input.nextLine();
                    System.out.print("Last Name: ");
                    lastname = input.nextLine();
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Email: ");
                    email = input.nextLine();
                    System.out.print("Mobile Number: ");
                    mobilenumber = input.nextLine();
                    System.out.print("Patient History: ");
                    patientHistory = input.nextLine();
                    System.out.print("Blood Type: ");
                    bloodType = input.nextLine().toUpperCase();
                    System.out.print("Gender: ");
                    String gender = input.nextLine();
                    System.out.print("Age: ");
                    age = input.nextLine();
                    System.out.print("Weight (KG): ");
                    weight = input.nextFloat();
                    System.out.print("Height (cm): ");
                    height = input.nextFloat();

                    new SignUp(firstname, lastname, username, email, password, mobilenumber, patientHistory, bloodType, gender, age, weight, height,  patientList);

                    System.out.println(" successfully signed up as patient");

                }
                case "receptionist" -> {
                    System.out.print("First Name: ");
                    firstname = input.nextLine();
                    System.out.print("Last Name: ");
                    lastname = input.nextLine();
                    System.out.print("Username: ");
                    username = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    System.out.print("Email: ");
                    email = input.nextLine();
                    System.out.print("Mobile Number: ");
                    mobilenumber = input.nextLine();
                    System.out.print("Gender: ");
                    String gender = input.nextLine();
                    System.out.print("Age: ");
                    int rage = input.nextInt();
                    new SignUp(firstname, lastname, username, email, password, mobilenumber, gender, rage, receptionistList);
                    System.out.println(" successfully signed up as receptionist");

                }
                default -> {
                    System.out.println("Please Enter Only One Of those: 'doctor', 'patient', or 'receptionist'.");
                }

            }
            input.close();
        }
        else if (Enter == 2) {
            System.out.println("[1] Login As A Doctor \n[2] Login As A Patient \n[3] Login As A Receptionist");
            System.out.print("Choose login type: ");
            Scanner scanner1 = new Scanner(System.in);
            int choice =  scanner1.nextInt();

            Scanner login = new Scanner(System.in);
            System.out.print("Enter username: ");
            username = login.nextLine();
            System.out.print("Enter password: ");
            password = login.nextLine();

            boolean isValid;

            switch (choice) {
                case 1:
                    isValid = loginSystem.validateDoctor(username, password);
                    if (isValid) {
                        System.out.println("Doctor logged in successfully!");
                    } else {
                        System.out.println("Invalid credentials for Doctor.");
                    }
                    break;
                case 2:
                    isValid = loginSystem.validatePatient(username, password);
                    if (isValid) {
                        System.out.println("Patient logged in successfully!");
                        Patient.patientMenu();
                    } else {
                        System.out.println("Invalid credentials for Patient.");
                    }
                    break;
                case 3:
                    isValid = loginSystem.validateReceptionist(username, password);
                    if (isValid) {
                        System.out.println("Receptionist logged in successfully!");
                    } else {
                        System.out.println("Invalid credentials for Receptionist.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}