package OOP;

import java.util.ArrayList;
import java.util.Scanner;

class SignUp extends User {
    private final Scanner scanner = new Scanner(System.in);
    private final Login loginSystem = new Login();

    public void Sign_Up(ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Receptionist> receptionists,
                       ArrayList<Appointment> appointment) {
        System.out.println("=============================================================");
        System.out.println("Welcome to the Dental Clinic. Do you want to Login or Signup?");
        System.out.println("[1] SignUp \n[2] Login");
        System.out.println("=============================================================");
        boolean FaultInput=false;
       do{
        int logOrSign = inputInt("Enter your choice: ");
           int userType;
        if (logOrSign == 1) {
            System.out.println("================\n"+
                    "SignUp As\n" +
                    "[1] Doctor\n" +
                    "[2] Patient\n" +
                    "[3] Receptionist\n"
                    +"================");
            boolean Fault = false;
            do{
                 userType=inputInt("Enter your choice: ");
                switch (userType) {
                    case 1 -> registerDoctor(doctors,patients,receptionists,appointment);
                    case 2 -> registerPatient(patients,doctors,appointment);
                    case 3 -> registerReceptionist(receptionists,appointment,patients);
                    default -> {
                        System.out.println("Invalid selection. Please enter 'doctor', 'patient', or 'receptionist'.");
                        Fault = true;
                    }
                }
            }while(Fault);

        } else if (logOrSign == 2) {
            loginSystem.logIn(doctors, patients, receptionists, appointment);
        }
        else {
            System.out.println("Invalid choice. Please enter 1 for SignUp or 2 for Login.");
            FaultInput=true;
        }
       }while(FaultInput);
    }


    private void registerDoctor(ArrayList<Doctor> doctors,ArrayList<Patient> patients,ArrayList<Receptionist> receptionists,ArrayList<Appointment> Appointment) {
        System.out.println("Registering as Doctor:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = input("Email: ");
        String password = inputPassword("Password");
        String mobileNumber = input("Mobile Number: ");
        String specialization = input("Speciality: ");


        Doctor doctor=new Doctor(firstname,lastname,username,email,password,mobileNumber,specialization);
        doctors.add(doctor);
        System.out.println("Successfully Signed Up As A Doctor.");
        doctor.doctorMenu(Appointment,receptionists,patients,doctors);
    }

    private void registerPatient(ArrayList<Patient> patients,ArrayList<Doctor> doctors,ArrayList<Appointment>appointment) {
        System.out.println("Registering as Patient:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = input("Email: ");
        String password = inputPassword("Password");
        String mobileNumber = input("Mobile Number: ");
        String patientHistory = input("Patient History: ");
        String bloodType = input("Blood Type: ").toUpperCase();
        String gender = input("Gender: ");
        String age = input("Age: ");
        float weight = inputFloat("Weight (KG): ");
        float height = inputFloat("Height (cm): ");

        Patient patient = new Patient(firstname, lastname, username, email, password, mobileNumber, patientHistory, bloodType, gender, age, weight, height);
        patients.add(patient);
        System.out.println("Successfully Signed Up As A Patient.");
       patient.patientMenu(doctors,appointment);
    }

    private void registerReceptionist(ArrayList<Receptionist> receptionists,ArrayList<Appointment>appointment,ArrayList<Patient>patients) {
        System.out.println("Registering as Receptionist:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = input("Email: ");
        String password = inputPassword("Password");
        String mobileNumber = input("Mobile Number: ");
        String gender = input("Gender: ");
        int age = inputInt("Age: ");

        Receptionist receptionist = new Receptionist(firstname, lastname, username, email, password, mobileNumber, gender, age);
        receptionists.add(receptionist);
        System.out.println("Successfully Signed Up As A Receptionist.");
        receptionist.receptionistMenu(appointment,patients);
    }


}
