package OOP;

import java.util.ArrayList;
import java.util.Scanner;

class SignUp extends User {
    private final Scanner scanner = new Scanner(System.in);
    private final Login loginSystem = new Login();

    public void Sign_Up(ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Receptionist> receptionists,
                       ArrayList<Appointment> Appointment) {
        System.out.println("=============================================================");
        System.out.println("Welcome to the Dental Clinic. Do you want to Login or Signup?");
        System.out.println("[1] SignUp \n[2] Login\n[3] Show data About Clinic");
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
                    case 1 -> registerDoctor(doctors);
                    case 2 -> registerPatient(patients);
                    case 3 -> registerReceptionist(receptionists);
                    default -> {
                        System.out.println("Invalid selection. Please enter 'doctor', 'patient', or 'receptionist'.");
                        Fault = true;
                    }
                }
            }
            while(Fault);
            boolean flag = false;
            System.out.println("Do you want continue or close the program?\n"+
                    "[1]continue\n" +
                    "[2]Close the program");
            do{
            int continueOrLogout=inputInt("Enter your choice: ");
            switch (continueOrLogout) {
                case 1->{
                    if(userType==1){//doc
                        Doctor doc=new Doctor();
                        doc.doctorMenu(Appointment,receptionists,patients,doctors);
                    }else if(userType==2){//pat
                        Patient patient=new Patient();
                        patient.patientMenu(doctors,Appointment);
                    }
                    else if(userType==3){//rec
                        Receptionist re=new Receptionist();
                        re.receptionistMenu(Appointment);
                    }

                }case 2->  {
                    System.out.println("Thank you for using Dental Clinic");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Not valid input. Please try again. ");
                    flag=true;
                }
            }

            }while(flag);

        } else if (logOrSign == 2) {
            loginSystem.logIn(doctors, patients, receptionists, Appointment);
        } else if(logOrSign == 3) {
            Dental_clinic clinic = new Dental_clinic();
            clinic.showMenu(doctors,patients,receptionists,Appointment);
        }
        else {
            System.out.println("Invalid choice. Please enter 1 for SignUp or 2 for Login.");
            FaultInput=true;
        }
       }while(FaultInput);
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



        doctors.add(new Doctor(firstname,lastname,username,email,password,mobileNumber,specialization));
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

        Patient patient = new Patient(firstname, lastname, username, email, password, mobileNumber, patientHistory, bloodType, gender, age, weight, height);
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

        Receptionist receptionist = new Receptionist(firstname, lastname, username, email, password, mobileNumber, gender, age);
        receptionists.add(receptionist);
        System.out.println("Successfully Signed Up As A Receptionist.");
    }


}
