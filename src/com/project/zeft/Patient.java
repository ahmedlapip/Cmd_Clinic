package com.project.zeft;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Patient extends User {
    protected String patientHistory, gender, bloodType;
    protected float weight;
    protected float height;
    static Scanner sc = new Scanner(System.in);
//12
    //,not,Male,O+,19,60.0,170.0
    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber, int age, String gender, String bloodType, String patientHistory, float weight, float height) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
        this.patientHistory = patientHistory;
    }

    public void updateInfo() {
        boolean bool = false;
        do {
            int choice = inputInt("What do you want to change? \n[1]Email \n[2]Mobile Number \n[3]Weight \n[4] Height) : ");
            switch (choice) {
                case 1 -> setEmail(inputEmail("Enter new email: "));
                case 2 -> setMobileNumber("Mobile number");
                case 3 -> setWeight();
                case 4 -> setHeight();
                default -> {
                    System.out.println("Invalid choice .choose 1 or 2 or 3 or 4");
                    bool = true;
                }
            }
        } while (bool);
        System.out.println("Updated Successfully");
    }

    public void reserveAppointment(ArrayList<Appointment> appointmentList) {
        pause(1000);
        clear();
        showAvailableAppointments(appointmentList);
        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");
        LocalTime time = inputTime("Enter time (HH:MM): ",date);
        for (Appointment appointment : appointmentList) {

            if (appointment.getDate().equals(date) && appointment.getTime().equals(time) && appointment.getAppointed().equals("false")) {
                appointment.setPatientUserName(this.username);
                appointment.setPhoneNumber(super.getMobileNumber());
                appointment.setAppointed("true");
                System.out.println("Appointment reserved for " + date + " at " + time + " with dr." + appointment.getDoctorUserName());
                return;
            }
        }
        System.out.println("You Cannot Appointment on " + date + " at " + time + " already exists.");
    }

    public void PrescriptionForPatient(ArrayList<Prescription> prescriptionList) {
        pause(1000);
        clear();
        boolean bool = false;
        for (Prescription prescription : prescriptionList) {
            if (prescription.getUserName().equals(this.username)) {
                System.out.println("You Have Medicine " + prescription.getMedicine_Name() + "that You Have to take " + prescription.getDosage() + " Daily");
                bool = true;
            }
        }
        if (!bool)
            System.out.println("You Have No Prescription ");
    }

    public void cancelReservation(ArrayList<Appointment> appointmentList) {
        pause(1000);
        clear();
        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");
        LocalTime time = inputTime("Enter time (HH:MM): ",date);
        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time) && appointment.getPhoneNumber().equals(getMobileNumber())) {
                appointment.setAppointed("false");
                appointment.setPatientUserName(" ");
                appointment.setPhoneNumber(" ");
                System.out.println("Appointment on " + date + " at " + time + " has been canceled.");
                return;
            }
        }
        System.out.println("No appointment found for " + date + " at " + time + ".");
    }

    public void checkPrices(ArrayList<Appointment> appointmentList) {
        pause(1000);
        clear();
        boolean bool = false;
        int count = 0;
        for (Appointment appointment : appointmentList) {
            if (appointment.getPatientUserName().equals(this.getUsername())) {
                count++;
                bool = true;
            }
        }
        System.out.println("You have " + count + " appointment(s).");
        System.out.println("Total price: " + count * Doctor.PRICE + " EGP");
        if (!bool)
            System.out.println("No appointments found.");
    }

    public void searchForDoctor(ArrayList<Doctor> doctorList) {
        pause(1000);
        clear();
        boolean bool = false;
        String search = input("Enter doctor name or mobile number: ");
        for (Doctor doctor : doctorList) {
            if (doctor.getName().equalsIgnoreCase(search) || doctor.getMobileNumber().equals(search)) {
                System.out.println("Doctor found");
                System.out.println("======================================");
                System.out.println("Doctor Name: " + doctor.getName());
                System.out.println("Doctor Mobile Number: " + doctor.getMobileNumber());
                System.out.println("Doctor Email: " + doctor.getEmail());
                System.out.println("======================================");
                bool = true;
            }
        }
        if (!bool)
            System.out.println("No doctor found.");
    }
//age, String gender, String bloodType, String patientHistory, float weight, float height
    public String toString() {
        return super.toString() + "," + age + "," + gender + "," + bloodType + "," + patientHistory + "," + weight + "," + height;
    }

    public static Patient fromString(String data) {
        String[] parts = data.split(",");
//age, String gender, String bloodType, String patientHistory, float weight, float height
        int age = 0;
        try {
            age = Integer.parseInt(parts[6]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid age value: " + parts[6] + ". Setting default value (0).");
        }

        float weight = 0.0f;
        try {
            weight = Float.parseFloat(parts[10]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid weight value: " + parts[10] + ". Setting default value (0.0).");
        }

        float height = 0.0f;
        try {
            height = Float.parseFloat(parts[11]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid height value: " + parts[11] + ". Setting default value (0.0).");
        }
        return new Patient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], age, parts[7], parts[8], parts[9], weight, height);
    }

    public void showAvailableAppointments(ArrayList<Appointment> appointmentList) {
        boolean bool = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointed().equals("false")) {
                System.out.println("There is an appointments on " + appointment.getDate() + " at " + appointment.getTime() + "with dr." + appointment.getDoctorUserName());
                bool = true;
            }
        }
        if (!bool)
            System.out.println("there Is No Appointments");
    }

    public void showAvailableAppointments(ArrayList<Appointment> appointmentList, String s) {
        boolean f = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getPatientUserName().equals(this.username) && (appointment.getAppointed().equals(s))) {
                System.out.println("There is an appointments on " + appointment.getDate() + " at " + appointment.getTime());
                f = true;
            }
        }
        if (!f)
            System.out.println("there Is No Appointments");
    }

    public String getBloodType() {

        return bloodType;
    }

    protected static String setBloodType(String prompt) {
        String bloodType = null;
        while (bloodType == null) {
            try {
                System.out.print(prompt);
                bloodType = sc.nextLine().trim().toUpperCase();

                if (bloodType.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please try again.");
                }

                if (!bloodType.matches("^(A|B|AB|O)[+-]?$")) {
                    throw new IllegalArgumentException("Invalid blood type. Please enter a valid blood type (e.g., A+, B-, AB+, O-).");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                bloodType = null;
            }
        }
        return bloodType;
    }

    public float getHeight() {

        return height;
    }

    public static float setHeight() {

        do {
            float height = inputFloat("Enter height(cm): ");
            if (height > 50 && height <= 200)
                return height;
            else {
                System.out.println("Invalid height, please try again");
            }
        } while (true);
    }

    public float getWeight() {

        return weight;
    }

    public String getPatientHistory() {

        return patientHistory;
    }

    public static float setWeight() {

        do {
            float weight = inputFloat("Enter weight(KG):");
            if (weight > 10 && weight <= 300)
                return weight;
            else {
                System.out.println("Invalid Weight, please try again");
            }
        } while (true);
    }

    public void patientMenu(ArrayList<Doctor> doctorList, ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptionList) {

        do {
            pause(1000);
            clear();
            int choice = inputInt("Choose an option:\n[1]  Reserve Appointment \n[2] Cancel Reservation \n[3] Check Prices \n[4] Search for Doctor \n[5] Show Your Appointments \n[6] Update Information \n[7] Show your Prescription \n[0] Back\n");

            switch (choice) {
                case 1 -> reserveAppointment(appointmentList);
                case 2 -> cancelReservation(appointmentList);
                case 3 -> checkPrices(appointmentList);
                case 4 -> searchForDoctor(doctorList);
                case 5 -> showAvailableAppointments(appointmentList, "true");
                case 6 -> updateInfo();
                case 7 -> PrescriptionForPatient(prescriptionList);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

}