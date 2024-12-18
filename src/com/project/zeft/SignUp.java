package com.project.zeft;

import java.util.ArrayList;

class SignUp extends Login {
    private final Login loginSystem = new Login();

    public void Sign_Up(ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Receptionist> receptionists,
                        ArrayList<Appointment> appointment, ArrayList<Prescription> prescriptionList) {
        pause(1000);
        clear();
        System.out.println("=============================================================");
        System.out.println("Welcome to the Dental Clinic. Do you want to Login or Signup?");
        System.out.println("[1] SignUp \n[2] Login");
        System.out.println("=============================================================");
        boolean FaultInput = false;
        do {
            int logOrSign = inputInt("Enter your choice: ");
            int userType;
            if (logOrSign == 1) {
                System.out.println("[1] Doctor \n[2] Patient \n[3] Receptionist \n[0] Back");
                boolean Fault = false;
                do {
                    userType = inputInt("Enter your choice: ");
                    switch (userType) {
                        case 0 -> {
                            return;
                        }
                        case 1 -> registerDoctor(doctors, patients, receptionists, appointment, prescriptionList);
                        case 2 -> registerPatient(patients, doctors, appointment, prescriptionList);
                        case 3 -> registerReceptionist(receptionists, appointment, patients);
                        default -> {
                            System.out.println("Invalid selection. Please enter 'doctor', 'patient', or 'receptionist'.");
                            Fault = true;
                        }
                    }
                } while (Fault);

            } else if (logOrSign == 2) {
                loginSystem.logIn(doctors, patients, receptionists, appointment, prescriptionList);
            } else {
                System.out.println("Invalid choice. Please enter 1 for SignUp or 2 for Login.");
                FaultInput = true;
            }
        } while (FaultInput);
    }

    private void registerDoctor(ArrayList<Doctor> doctors, ArrayList<Patient> patients, ArrayList<Receptionist> receptionists, ArrayList<Appointment> Appointment, ArrayList<Prescription> prescriptionList) {
        pause(500);
        clear();
        System.out.println("Registering as Doctor:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = inputEmail("Email: ");
        String password = inputPassword("Password: ");
        System.out.println(password);
        String mobileNumber = setMobileNumber("Mobile number: ");
        for (Doctor d : doctors) {
            if (d.getMobileNumber().equals(mobileNumber)) {
                System.out.println("Mobile number already in use");
            }
        }
        String specialization = input("Speciality: ");


        Doctor doctor = new Doctor(firstname, lastname, username, email, password, mobileNumber, specialization);
        doctors.add(doctor);
        System.out.println("Successfully Signed Up As A Doctor.");
        doctor.doctorMenu(Appointment, receptionists, patients, prescriptionList);
    }

    private void registerPatient(ArrayList<Patient> patients, ArrayList<Doctor> doctors, ArrayList<Appointment> appointment, ArrayList<Prescription> prescriptionList) {
        pause(500);
        clear();
        System.out.println("Registering as Patient:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = inputEmail("Email: ");
        String password = inputPassword("Password: ");
        String mobileNumber = setMobileNumber("Mobile number: ");
        String patientHistory = input("Patient History: ");
        String bloodType = Patient.setBloodType("Blood Type: ");
        String gender = setGender("Gender: ");
        int age = getAge();
        float weight = Patient.setWeight();
        float height = Patient.setHeight();
        Patient patient = new Patient(firstname, lastname, username, email, password, mobileNumber, age, bloodType, gender, patientHistory, weight, height);
        patients.add(patient);
        System.out.println("Signed successfully.");
        patient.patientMenu(doctors, appointment, prescriptionList);
    }

    private void registerReceptionist(ArrayList<Receptionist> receptionists, ArrayList<Appointment> appointment, ArrayList<Patient> patients) {
        pause(500);
        clear();
        System.out.println("Registering as Receptionist:");
        String firstname = input("First Name: ");
        String lastname = input("Last Name: ");
        String username = input("Username: ");
        String email = inputEmail("Email: ");
        String password = inputPassword("Password: ");
        String mobileNumber = setMobileNumber("Mobile number: ");
        String gender = setGender("Gender: ");
        int age = getAge();
        for (Receptionist receptionist : receptionists) {
            if (receptionist.getUsername().equals(username)) {
                System.out.println("Enter unique Username :");
                break;
            }
        }
        Receptionist receptionist = new Receptionist(firstname, lastname, username, email, password, mobileNumber, gender, age);
        receptionists.add(receptionist);
        System.out.println("Signed Successfully");
        receptionist.receptionistMenu(appointment, patients);
    }
}
