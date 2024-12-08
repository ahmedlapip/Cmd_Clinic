package OOP;

import java.util.ArrayList;
import java.util.Scanner;
class SignUp extends User {
Scanner scanner = new Scanner(System.in);
Login loginSystem ;


public void Sign_UP(ArrayList<Patient>patients,ArrayList<Doctor>doctors,ArrayList<Receptionist>receptionists){
    System.out.println("Welcome to the Dental Clinic. Do you want to Login or Signup?");
        System.out.println("[1] SignUp \n[2] Login");
        System.out.print("Enter Your choice: ");
    int Log_Or_Sign = scanner.nextInt();

        if (Log_Or_Sign == 1){
        System.out.println("select (doctor/patient/receptionist):");
        System.out.print("Enter Your Choice: ");
        String userType = scanner.nextLine().toLowerCase();

        switch (userType) {
            case "doctor" -> {
                String firstname, lastname, username, email, password, mobilenumber, availableDays, availableHours;
                System.out.print("First Name: ");
                 firstname= scanner.nextLine();
                System.out.print("Last Name: ");
                lastname = scanner.nextLine();
                System.out.print("Username: ");
                username = scanner.nextLine();
                System.out.print("Email: ");
                email = scanner.nextLine();
                System.out.print("Password: ");
                password = scanner.nextLine();
                System.out.print("Mobile Number: ");
                mobilenumber = scanner.nextLine();
                System.out.print("Available Days: ");
                availableDays = scanner.nextLine();
                System.out.print("Available Hours: ");
                availableHours = scanner.nextLine();
                Doctor doctor = new Doctor(firstname, lastname, username, email, password, mobilenumber, availableDays, availableHours);
                doctors.add(doctor);
                System.out.println("Successfully Signed Up As A Doctor");

            }
            case "patient" -> {
                String firstname, lastname, username, email, password, mobilenumber, patientHistory, bloodType, gender,age;
                float weight,height;
               System.out.print("First Name: ");
               firstname = scanner.nextLine();
               System.out.print("Last Name: ");
               lastname = scanner.nextLine();
               System.out.print("Username: ");
               username = scanner.nextLine();
               System.out.print("Password: ");
               password = scanner.nextLine();
               System.out.print("Email: ");
               email = scanner.nextLine();
               System.out.print("Mobile Number: ");
               mobilenumber = scanner.nextLine();
               System.out.print("Patient History: ");
               patientHistory = scanner.nextLine();
               System.out.print("Blood Type: ");
               bloodType = scanner.nextLine().toUpperCase();
               System.out.print("Gender: ");
               gender = scanner.nextLine();
               System.out.print("Age: ");
               age = scanner.nextLine();
               System.out.print("Weight (KG): ");
               weight = scanner.nextFloat();
               System.out.print("Height (cm): ");
               height = scanner.nextFloat();
               Patient patient = new Patient(firstname, lastname, username, password, email, mobilenumber, patientHistory, bloodType, gender, age, weight, height);
               patients.add(patient);
               System.out.println(" successfully signed up as patient");
            }
            case "receptionist" -> {
                String firstname, lastname, username, email, password, mobilenumber;
                System.out.print("First Name: ");
                firstname = scanner.nextLine();
                System.out.print("Last Name: ");
                lastname = scanner.nextLine();
                System.out.print("Username: ");
                username = scanner.nextLine();
                System.out.print("Password: ");
                password = scanner.nextLine();
                System.out.print("Email: ");
                email = scanner.nextLine();
                System.out.print("Mobile Number: ");
                mobilenumber = scanner.nextLine();
                System.out.print("Gender: ");
                String gender = scanner.nextLine();
                System.out.print("Age: ");
                int rage = scanner.nextInt();
                Receptionist receptionist = new Receptionist(firstname, lastname, username, password, email, mobilenumber, gender, rage);
                receptionists.add(receptionist);
                System.out.println(" successfully signed up as receptionist");

            }
            default -> {
                System.out.println("Please Enter Only One Of those: 'doctor', 'patient', or 'receptionist'.");
            }

        }
        scanner.close();
    }
        else if (Log_Or_Sign == 2) {
        loginSystem.Log_IN(doctors, patients, receptionists);
}
}
}

