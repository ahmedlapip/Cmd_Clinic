package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Receptionist extends User {
    private String gender;
    private int age;

    private final Scanner sc = new Scanner(System.in);

    // Constructors
    public Receptionist() {}

    public Receptionist(String firstName, String lastName, String username, String email, String password,
                        String mobileNumber, String gender, int age) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.gender = gender;
        this.age = age;
    }

    public Receptionist(String username, String password) {
        super(username, password);
    }

    // Update Receptionist Information
    public void updateInfo() {
        String choice = input("What do you want to change? (Email, Mobile Number, Gender, Age): ");

        switch (choice.toLowerCase()) {
            case "email" -> setEmail(input("Enter new email: "));
            case "mobile number" -> setMobileNumber(input("Enter new mobile number: "));
            case "gender" -> gender = input("Enter new gender: ");
            case "age" -> age = inputInt("Enter new age: ");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    // View Appointments
    public void viewAppointments(ArrayList<Appointment> appointmentList) {
        System.out.println("Appointments:");
        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);
        }
    }

    // Add Appointment
    public void addAppointment(ArrayList<Appointment> appointmentList) {
        String date = input("Enter date (YYYY-MM-DD): ");
        String time = input("Enter time (HH:MM): ");
        String patientName = input("Enter patient name: ");
        String mobileNumber = input("Enter patient mobile number: ");

       /* Appointment newAppointment = new Appointment(patientName, mobileNumber, date, time,);
        appointmentList.add(newAppointment);
        System.out.println("Appointment added successfully.");*/
    }

    // Cancel Appointment
    public void cancelAppointment(ArrayList<Appointment> appointmentList) {
        String date = input("Enter date (YYYY-MM-DD): ");
        String time = input("Enter time (HH:MM): ");

        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                appointmentList.remove(appointment);
                System.out.println("Appointment on " + date + " at " + time + " has been canceled.");
                return;
            }
        }
        System.out.println("No matching appointment found.");
    }

    // Interactive Menu for Receptionist
    public void receptionistMenu(ArrayList<Appointment> appointmentList) {
        System.out.println("""
            Choose an option:
            1 -> View Appointments
            2 -> Add Appointment
            3 -> Cancel Appointment
            4 -> Update Info
        """);

        int choice = sc.nextInt();
        sc.nextLine(); // Clear newline character

        switch (choice) {
            case 1 -> viewAppointments(appointmentList);
            case 2 -> addAppointment(appointmentList);
            case 3 -> cancelAppointment(appointmentList);
            case 4 -> updateInfo();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "," + gender + "," + age;
    }

    public static Receptionist fromString(String line) {
        String[] fields = line.split(",");
        if (fields.length != 8) { // Adjust based on the number of fields
            throw new IllegalArgumentException("Invalid data format for Receptionist.");
        }

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
