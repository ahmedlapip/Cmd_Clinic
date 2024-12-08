package OOP;

import java.util.ArrayList;

public class Login {
    public ArrayList<Doctor> doctors;
    public ArrayList<Patient> patients;
    public ArrayList<Receptionist> receptionists;

    public Login(ArrayList<Doctor> doctors, ArrayList<Patient> patients, ArrayList<Receptionist> receptionists) {
        this.doctors = doctors;
        this.patients = patients;
        this.receptionists = receptionists;
    }
    public void out()
    {
        System.out.println("Patients loaded:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
    public boolean validateDoctor(String username, String password) {
        for (Doctor doctor : doctors) {
            if (doctor.getUsername().equals(username) && doctor.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Validate Patient's login credentials
    public boolean validatePatient(String username, String password) {
        for (Patient patient : patients) {
            if (patient.getUsername().equals(username) && patient.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Validate Receptionist's login credentials
    public boolean validateReceptionist(String username, String password) {
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username) && receptionist.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
