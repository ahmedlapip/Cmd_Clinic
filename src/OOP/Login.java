package OOP;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends User {
    private final Scanner scanner = new Scanner(System.in);

    public void out(Patient[] patients) {
        System.out.println("Patients loaded:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    // Validate Doctor's login credentials
    public void validateDoctor(String username, String password, ArrayList<Appointment> appointmentList,
                               ArrayList<Receptionist> receptionistList, ArrayList<Patient>patientList,ArrayList<Doctor>doctorList) {
        for (Doctor doctor : doctorList) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
               System.out.println("Doctor logged in successfully!");
                doctor.doctorMenu(appointmentList,receptionistList, patientList,doctorList);
                return ;
            }

        }

            System.out.println("Invalid credentials. Please check your username and password for Doctor login.");


    }

    // Validate Patient's login credentials
    public void validatePatient(String username, String password , ArrayList<Patient> patients
            ,ArrayList<Doctor> doctors,ArrayList<Appointment> appointmentList) {
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
    public void validateReceptionist(String username, String password, ArrayList<Receptionist> receptionists,
                                     ArrayList<Appointment> appointmentList,ArrayList<Patient> patientList) {
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
               System.out.println("Receptionist logged in successfully!");
               receptionist.receptionistMenu(appointmentList,patientList);
                return;
            }
            else {
                System.out.println("Invalid credentials. Please check your username and password for Receptionist login.");
            }
        }

    }

    public void logIn(ArrayList<Doctor> doctors, ArrayList<Patient> patients,
                      ArrayList<Receptionist> receptionists,ArrayList<Appointment> appointmentList) {
        System.out.println("===========================");
        System.out.println("[1] Login As A Doctor \n[2] Login As A Patient \n[3] Login As A Receptionist");
        System.out.println("===========================");

        // Ensure valid numeric choice
        boolean Fault_log = false;
        do {
        int choice = inputInt("Enter your choice: ");

        String username =input("Enter username: ");

        String password = inputPassword("Enter Password: ");

        switch (choice) {
            case 1 -> {
             validateDoctor(username, password, appointmentList, receptionists, patients, doctors);
            }
            case 2 -> {
                validatePatient(username,password,patients,doctors,appointmentList);

            }
            case 3 -> {
               validateReceptionist(username, password, receptionists, appointmentList,patients);

            }
            default -> {
                System.out.println("Invalid choice. Please select between 1, 2, or 3.");
                Fault_log=true;
            }
        }}while(Fault_log);
    }


}
