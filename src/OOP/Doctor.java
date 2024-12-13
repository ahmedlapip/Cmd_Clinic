package OOP;

import java.sql.SQLOutput;
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
    public String toString() {
        return super.toString() + "," + specialization;
    }
    public  static Doctor  fromString(String data) {
        String[] parts = data.split(",");
        return new Doctor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }


    // Display Doctor's Menu
    public  void doctorMenu(ArrayList<Appointment> appointmentList,ArrayList<Receptionist> receptionistList,
                           ArrayList<Patient>patientList,ArrayList<Doctor>doctorList) {
boolean For_menu=false;
do{
        int choice = inputInt("""
            Choose an option:
            1 -> Reserve Appointment
            2 -> Change Available Day
            3 -> Show Available Days
            4 -> Get Contact Information of the receptionist
            5 -> Get patient information
        """);

        switch (choice) {
            case 1 -> ReserveAppointment(appointmentList);
            case 2 -> changeAvailability(appointmentList);
            case 3 -> ShowForDay(appointmentList);
            case 4 -> getInfoAboutReceptionist(receptionistList);
            case 5 -> getInfoAboutPatient(patientList,doctorList,appointmentList);
            default -> {
                System.out.println("Invalid choice. Please try again.");
                For_menu=true;
            }
        }}while(For_menu);
    }
    public void getInfoAboutReceptionist(ArrayList<Receptionist>receptionistList){
        int i = 1;
        for (Receptionist receptionist : receptionistList) {
            System.out.println("==============================================");
            System.out.println("Receptionist " + i  + " Name : "+ receptionist.getName()
                    +"\nReceptionist " + i  + " Phone Number : " +receptionist.getMobileNumber());
        }
        System.out.println("==============================================");

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