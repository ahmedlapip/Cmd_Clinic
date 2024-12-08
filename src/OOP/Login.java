package OOP;

import java.util.ArrayList;
import java.util.Scanner;


public class Login {
  Scanner scanner = new Scanner(System.in);

    public void out(Patient[] patients)
    {
        System.out.println("Patients loaded:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
    public boolean validateDoctor(String username, String password, ArrayList<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Validate Patient's login credentials
    public boolean validatePatient(String username, String password,ArrayList<Patient> patients) {
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Validate Receptionist's login credentials
    public boolean validateReceptionist(String username, String password, ArrayList<Receptionist> receptionists) {
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void Log_IN(ArrayList<Doctor> doctors, ArrayList<Patient> patients, ArrayList<Receptionist> receptionists){
        String username, password;
        boolean valid = false;
        System.out.println("[1] Login As A Doctor \n[2] Login As A Patient \n[3] Login As A Receptionist");
        System.out.print("Choose login type: ");
        int choice =  scanner.nextInt();


        System.out.print("Enter username: ");
        username = scanner.nextLine();
        System.out.print("Enter password: ");
        password = scanner.nextLine();

        boolean isValid;

        switch (choice) {
            case 1:
                isValid = this.validateDoctor(username, password,doctors);
                if (isValid) {
                    System.out.println("Doctor logged in successfully!");
                } else {
                    System.out.println("Invalid credentials for Doctor.");
                }
                break;
            case 2:
                isValid = this.validatePatient(username, password,patients);
                if (isValid) {
                    System.out.println("Patient logged in successfully!");
                    Patient.patientMenu();
                } else {
                    System.out.println("Invalid credentials for Patient.");
                }
                break;
            case 3:
                isValid = this.validateReceptionist(username, password,receptionists);
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

    }


