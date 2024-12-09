package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends User {
    public static final int  PRICE = 400;
    private String specialization;
    private final Scanner sc = new Scanner(System.in);

    // Constructors
    public Doctor() {}

    public Doctor(String userName, String password) {
        super(userName, password);
    }
//fName,lName,uName,email,pass,num,specialization
    public Doctor(String firstName, String lastName, String username, String email, String password, String mobileNumber, String specialization) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.specialization = specialization;
    }

    public void ReserveAppointment(ArrayList<Appointment> appointmentList) {
        String date=input("Enter date (YYYY-MM-DD): ");
        String time = input("Enter time (HH:MM): ");
        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                System.out.println("An appointment on " + date + " at " + time + " already exists.");
                return;
            }
            else {
                Appointment newAppointment = new Appointment("empty","empty",date,time,this.getName(),this.getMobileNumber(),"false");
                appointmentList.add(newAppointment);
                System.out.println("Appointment reserved for " + date + " at " + time);
                return;
            }
        }
    }

    // Update Doctor's Information
    public void updateInfo() {
        String choice = input("What do you want to change? (Email, Mobile Number, Specialization) : ");

        switch (choice.toLowerCase()) {
            case "email" -> setEmail(input("Enter new email: "));
            case "mobile number" -> setMobileNumber(input("Enter new mobile number: "));
            case "specialization" -> specialization = input("Enter new specialization: ");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }



    // Show Available Days
    public void ShowForDay(ArrayList<Appointment> appointmentList) {
       for (Appointment appointment : appointmentList) {
           if(appointment.getDate().equals(input("Enter date (YYYY-MM-DD): ")) && appointment.getAppointed().equals("true")) {
               System.out.println("You Have Appiontment At "+appointment.getTime());
           }
       }
    }

   //Change Availability
    public void changeAvailability(ArrayList<Appointment> appointmentList) {
        for (Appointment appointment : appointmentList) {
            if(appointment.getDate().equals(input("Enter date (YYYY-MM-DD): ")) && appointment.getAppointed().equals("true"))
            {
                System.out.println("Inform Receptionist to update Patient time");
                appointmentList.remove(appointment);
            }
            else {
                System.out.println("Removed");
                appointmentList.remove(appointment);
            }
        }
    }
    public static Doctor fromString(String line) {
        String[] fields = line.split(",");

        // Validate the number of fields
        if (fields.length != 7) { // Adjust this number based on the expected fields for a Doctor
            throw new IllegalArgumentException("Invalid data format for Doctor.");
        }

        return new Doctor(
                fields[0], // First Name
                fields[1], // Last Name
                fields[2], // Username
                fields[3], // Email
                fields[4], // Password
                fields[5], // Mobile Number
                fields[6]  // Specialization
        );
    }


    // Display Doctor's Menu
    public void doctorMenu(ArrayList<Appointment> appointmentList,ArrayList<Receptionist> receptionistList,ArrayList<Patient>patientList,ArrayList<Doctor>doctorList) {
       // ● Get contact information of the receptionist ● Get patient information
        int choice = inputInt("""
            Choose an option:
            1 -> Update Information
            2 -> Reserve Appointment
            3 -> Change Available Day
            4 -> Show Available Days
            5 -> Get Contact Information of the receptionist
            6 -> Get patient information
        """); // Clear newline character

        switch (choice) {
            case 1 -> updateInfo();
            case 2 -> ReserveAppointment(appointmentList);
            case 3 -> changeAvailability(appointmentList);
            case 4 -> ShowForDay(appointmentList);
            case 5 -> getInfoAboutReceptionist(receptionistList);
            case 6 -> getInfoAboutPatient(patientList,doctorList,appointmentList);
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }
    public void getInfoAboutReceptionist(ArrayList<Receptionist>receptionistList){
        for (Receptionist receptionist : receptionistList) {
            System.out.println(" Receptionist Name :"+receptionist.getName()+"\nReceptionist Phone Number :"+receptionist.getMobileNumber());
        }

    }
    public void getInfoAboutPatient(ArrayList<Patient>patientList,ArrayList<Doctor>doctorList,ArrayList<Appointment>appointmentList){
        for(Appointment appointmet:appointmentList){
            for(Patient patient:patientList){
            if(appointmet.getDoctorName().equals(getName()) && appointmet.getPhoneNumber().equals(getMobileNumber()) && appointmet.getAppointed().equals("true")&&appointmet.getPatientName().equals(patient.getName())){
                System.out.println(" Patient Name :"+patient.getName()+"\nPatient Phone Number :"+patient.getMobileNumber()
                        +"Patient Blood Type"+patient.getBloodType()
                        +"\nPatient Weight"+patient.getWeight()
                        +"\nPatient Height"+patient.getHeight()
                        +"\nPaience History"+patient.getPatientHistory());
            }
            }
            }
        }
    }