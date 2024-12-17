package OOP;

import java.time.LocalDate;
import java.time.LocalTime;
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
        System.out.println("=====================================================================================================");
        for (Appointment appointment : appointmentList) {
            System.out.println("Patient Name: " + appointment.getPatient_U_Name() + ", Patient Mobile Number: " + appointment.getPhoneNumber()
            + ", Date: " + appointment.getDate() + ", Time: " + appointment.getTime() + "\n" + "Doctor Name: " + appointment.getDoctor_U_Name()
            + ", Doctor Mobile Number: " + appointment.getDoctorNum() + ", Available : " + appointment.getAppointed());
            System.out.println("=====================================================================================================");
        }
    }

    // Add Appointment
    public void ReserveAppointment(ArrayList<Appointment> appointmentList,ArrayList<Patient>patientList) {
        String patientName = input("Enter Your User Name: ");
        for(Patient patient : patientList) {
        for (Appointment appointment : appointmentList) {
            if (appointment.getPatient_U_Name().equals(patientName)) {
                appointment.setAppointed("true");
                System.out.println("The Appointment Reserved Successfully.");
                return;
            } else {
                System.out.println("There IS No Appointments With This Name.");
            }
        }
        }
    }

    // Cancel Appointment
    public void cancelAppointment(ArrayList<Appointment> appointmentList) {
        String Name = input("Enter Patient User Name: ");
        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");
        LocalTime time = inputTime("Enter time (HH:MM): ");

        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time) && appointment.getPatient_U_Name().equals(Name)) {
                appointmentList.remove(appointment);
                System.out.println("Appointment on " + date + " at " + time + " For Patient " + Name + " has been canceled.");
                return;
            }
        }
        System.out.println("No matching appointment found.");
    }

    // Interactive Menu for Receptionist
    public void receptionistMenu(ArrayList<Appointment> appointmentList,ArrayList<Patient>patientList) {
        boolean flag = false;
        do{
        int choice = inputInt("""
        ========================
        Choose an option:
        1 -> Reserve an appointment for patient
        2 -> Cancel Reservation For Patient
        3 -> Update Information
        ========================""");
        switch (choice) {
            case 1 -> ReserveAppointment(appointmentList,patientList);
            case 2 -> cancelAppointment(appointmentList);
            case 3 -> updateInfo();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                flag = true;
            }
        }}while(flag);
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
