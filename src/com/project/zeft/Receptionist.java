package com.project.zeft;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Receptionist extends User {
    private final String gender;
    private final int age;

    public Receptionist(String firstName, String lastName, String username, String email, String password,
                        String mobileNumber, String gender, int age) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.gender = gender;
        this.age = age;
    }

    public void updateInfo() {
        int choice = inputInt("What do you want to change? \n[1] Email \n[2] Mobile Number");

        switch (choice) {
            case 1 -> setEmail(input("Enter new email: "));
            case 2 -> this.mobileNumber = setMobileNumber("Mobile number");
            default -> System.out.println("Invalid choice. Please try again.");
        }
        System.out.println("Your Data have been Updated! ");
    }

    public void viewAppointments(ArrayList<Appointment> appointmentList) {
        System.out.println("Appointments:");
        System.out.println("=====================================================================================================");
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointed().equals("false")) {
                System.out.println("Patient Name:NULL" + ", Patient Mobile Number:NULL"
                        + ", Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + "\n" + "Doctor Name: " + appointment.getDoctorUserName()
                        + ", Doctor Mobile Number: " + appointment.getDoctorNum() + ", Available : " + appointment.getAppointed());
                System.out.println("=====================================================================================================");
            } else {
                System.out.println("Patient Name: " + appointment.getPatientUserName() + ", Patient Mobile Number: " + appointment.getPatientUserName()
                        + ", Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + "\n" + "Doctor Name: " + appointment.getDoctorUserName()
                        + ", Doctor Mobile Number: " + appointment.getDoctorNum() + ", Available : " + appointment.getAppointed());
                System.out.println("=====================================================================================================");

            }
        }
    }

    public void ReserveAppointment(ArrayList<Appointment> appointmentList, ArrayList<Patient> patientList) {
        String patientName = input("Enter Patient user name: ");
        Patient foundPatient = null;

        for (Patient patient : patientList) {
            if (patient.username.equals(patientName)) {
                foundPatient = patient;
                break;
            }
        }

        if (foundPatient != null) {
            boolean appointmentBooked = false;

            // Check if the patient already has an appointment today
            for (Appointment appointment : appointmentList) {
                if (appointment.getPatientUserName().equals(patientName) && appointment.getDate().equals(LocalDate.now())) {
                    System.out.println("You already have an appointment today at " + appointment.getTime());
                    appointmentBooked = true;
                    break;
                }
            }

            // Find an available appointment if not already booked
            if (!appointmentBooked) {
                for (Appointment appointment : appointmentList) {
                    if (appointment.getDate().equals(LocalDate.now())
                            && appointment.getTime().isAfter(LocalTime.now())
                            && appointment.getAppointed().equals("false")) {
                        appointment.setAppointed("true");
                        appointment.setPatientUserName(patientName);
                        appointment.setPhoneNumber(foundPatient.getMobileNumber());
                        System.out.println("Appointment reserved successfully at " + appointment.getTime());
                        appointmentBooked = true;
                        break;
                    }
                }
            }

            // No appointments available
            if (!appointmentBooked) {
                System.out.println("No available appointments for today.");
            }
        } else {
            System.out.println("Invalid username. \n[1] SignUp \n[2] Back");
            boolean validChoice = false;

            while (!validChoice) {
                int choice = inputInt("Enter Your Choice: ");
                switch (choice) {
                    case 1:
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
                        int age = inputInt("Age: ");
                        float weight = inputFloat("Weight (KG): ");
                        float height = inputFloat("Height (cm): ");
                        Patient newPatient = new Patient(firstname, lastname, username, email, password, mobileNumber, age, bloodType, gender, patientHistory, weight, height);
                        patientList.add(newPatient);
                        System.out.println("Patient registered successfully!");
                        validChoice = true;
                        break;
                    case 2:
                        validChoice = true;
                        return; // Exit the method
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }

    public void cancelAppointment(ArrayList<Appointment> appointmentList) {
        String Name = input("Enter Patient User Name: ");
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointed().equals("true") && appointment.getPatientUserName().equals(Name)) {
                System.out.println("Patient Name: " + Name + ", Patient Mobile Number: " + appointment.getPhoneNumber()
                        + ", Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + ' ' + " with dr." + appointment.getDoctorUserName());
                System.out.println("=====================================================================================================");
            }
        }
        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");
        LocalTime time = inputTime("Enter time (HH:MM): ");

        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time) && appointment.getPatientUserName().equals(Name)) {
                appointmentList.remove(appointment);
                System.out.println("Appointment on " + date + " at " + time + " For Patient " + Name + " has been canceled.");
                return;
            }
        }
        System.out.println("No matching appointment found.");
    }

    public void receptionistMenu(ArrayList<Appointment> appointmentList, ArrayList<Patient> patientList) {

        do {
            int choice = inputInt("[1] Reserve an appointment for patient \n[2] Cancel Reservation For Patient \n[3] Update Information \n[4] View appointments \n[0] Back\n");
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> ReserveAppointment(appointmentList, patientList);
                case 2 -> cancelAppointment(appointmentList);
                case 3 -> updateInfo();
                case 4 -> viewAppointments(appointmentList);
                default -> {
                    System.out.println("Invalid choice. Please try again.");

                }
            }
        } while (true);
    }

    @Override
    public String toString() {

        return super.toString() + "," + gender + "," + age;
    }

    public static Receptionist fromString(String line) {
        String[] fields = line.split(",");

        return new Receptionist(
                fields[0],  // First Name
                fields[1],  // Last Name
                fields[2],  // Username
                fields[3],  // Email
                fields[4],  // Password
                fields[5],  // Mobile Number
                fields[6],  // Gender
                Integer.parseInt(fields[7])  // Age
        );
    }

}