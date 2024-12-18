package com.project.zeft;

import java.util.ArrayList;

public class Dental_clinic extends SignUp {
    private final String Name;
    private final String Location;
    private final String ContactNumber;
    private final String Email;
    private final ArrayList<String> services;
    private final ArrayList<Integer> prices;
    static SignUp signUp = new SignUp();

    public Dental_clinic() {
        this.Name = "Smile Craft Dental Clinic";
        this.Location = "Cairo, Egypt";
        this.ContactNumber = "+20 123 456 789";
        this.Email = "contact@smilecraftclinic.com";
        this.services = new ArrayList<>();
        this.prices = new ArrayList<>();

        this.prices.add(0, 100); // Teeth cleaning
        this.prices.add(1, 200); // Tooth extractions
        this.prices.add(2, 300); // Wisdom tooth removal
        this.prices.add(3, 400); // Children's dentistry

        this.services.add(0, "Teeth cleaning");
        this.services.add(1, "Tooth extractions");
        this.services.add(2, "Wisdom tooth removal");
        this.services.add(3, "Children's dentistry");

        System.out.println("Welcome to Smile Craft Dental Clinic");
    }

    public void displayClinicInfo() {
        System.out.println("\n--- Clinic Information ---");
        System.out.println("Clinic Name: " + this.Name);
        System.out.println("Location: " + this.Location);
        System.out.println("Contact Number: " + this.ContactNumber);
        System.out.println("Email: " + this.Email);
        System.out.println("---------------------------");

        boolean bool = false;
        do {
            char c = inputChar("Do you want to Reserve Appointment? (Y/N)\n");
            switch (c) {
                case 'Y': {
                    System.out.println("Sign Up Or Login at first \n");

                    return;
                }
                case 'N': {

                    return;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    bool = true;
                }
            }
        } while (bool);
    }

    public String getName() {

        return Name;
    }

    public void showMenu(ArrayList<Doctor> doctorList, ArrayList<Patient> patientList, ArrayList<Receptionist> receptionistList, ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptionList) {

        int choice;
        boolean running = true;

        while (running) {
            pause(1000);
            clear();
            System.out.println("\n============================== MAIN MENU ================================");
            System.out.println("[1] View Services");
            System.out.println("[2] View Clinic Information");
            System.out.println("[3] Log In or Sign Up");
            System.out.println("[4] Exit");
            System.out.println("==========================================================================");
            choice = inputInt("Please choose an option (1-4): ");

            switch (choice) {
                case 1:
                    viewServices();

                    break;
                case 2:

                    displayClinicInfo();
                    break;
                case 3:

                    signUp.Sign_Up(patientList, doctorList, receptionistList, appointmentList, prescriptionList);
                    break;
                case 4:
                    System.out.println("Thank you for visiting Smile Craft Dental Clinic!");
                    pause(3000);
                    clear();
                    running = false;
                    FileHandler.saveEntity(doctorList, patientList, receptionistList, appointmentList, prescriptionList);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewServices() {
        System.out.println("\n--- Available Services ---");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i) + " - Price: " + prices.get(i) + " EGP");
        }
        System.out.println("---------------------------");
        boolean bool = false;
        do {
            char c = inputChar("Do you want to Reserve Appointment? (Y/N)\n");
            switch (c) {
                case 'Y': {
                    System.out.println("Sign Up Or Login at first \n");

                    return;
                }
                case 'N': {

                    return;
                }
                default: {
                    System.out.println("Invalid choice. Please try again.");
                    bool = true;
                }
            }
        } while (bool);

    }

}