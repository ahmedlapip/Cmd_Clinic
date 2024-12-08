package com.project.zeft;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Patient extends User {
protected String patientHistory, age, gender, bloodType;
protected float weight=0;
protected float height=0;
Scanner sc = new Scanner(System.in);
ArrayList<Appointment> appointmentList = new ArrayList<>();
/* Reserve an appointment with specific date and time. ● Cancel reservation. ● Check prices for appointments. ● Search for doctor with name or mobile number ● Display available appointments for reservation*/
public Patient() {}

    ///login
    public Patient (String userName,String password ){
        super(userName,password);

    }

    ///basic info
    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber){

    super(firstName, lastName, username, email, password, mobileNumber);
   }

    ///full info
    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber, String age, String gender, float weight, float height){

        super(firstName, lastName, username, email, password, mobileNumber);
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public void change (){
        System.out.println("What do you want to change? Email   Mobile Number   Weight  Height ");
        String choice = sc.nextLine();

        switch (choice) {
            case "Email" -> {
                System.out.println("Enter new email");
                String newEmail = sc.nextLine();
                setEmail(newEmail);
            }
            case "Mobile Number" -> {
                System.out.println("Enter new mobile number");
                String newMobileNumber = sc.nextLine();
                setMobileNumber(newMobileNumber);
            }
            case "Weight" -> {
                System.out.println("Enter new weight");
                float newWeight = sc.nextFloat();
                setWeight(newWeight);
            }
            case "Height" -> {
                System.out.println("Enter new height");
                float newHeight = sc.nextFloat();
                setHeight(newHeight);
            }
            default -> {
                System.out.println("Invalid choice");
            }
        }
    }
    public void reserveAppointment(String date, String time){
        System.out.println("Enter date and time for appointment");
        date = sc.nextLine();
        time = sc.nextLine();
        Appointment newAppointment = new Appointment(this.getName(),this.getMobileNumber(),date,time);
        appointmentList.add(newAppointment);
    }
    public void cancelReservation(String date, String time){
        System.out.println("Enter date and time to cancel appointment");
        date = sc.nextLine();
        time = sc.nextLine();
        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {
                appointmentList.remove(appointment);
                return;
            }
        }
        System.out.println("No appointment found for " + date + " at " + time + ".");

    }
    public void checkPrices(){
       System.out.println("you Have Appointments on ");
        int cnt=0;
       for (Appointment appointment : appointmentList) {
           if(appointment.getPatientName().equals(this.getName())&& appointment.getPhoneNumber().equals(this.getMobileNumber()) && cnt > 0){
            System.out.println(appointment.getDate() + " at " + appointment.getTime());
            cnt++;
           }
          }
       if(cnt>0) {
            System.out.println("Total appointments: " + cnt + "appointment(s)  " + "total Price : " + cnt * Doctor.Price + "EGP");
        }
       else {
           System.out.println("No appointments found");
       }
    }

    public void searchForDoctor(ArrayList<Doctor>doctorList){
        System.out.println("Enter Name or Mobile Number to search for doctor");
        String search = sc.nextLine();
        for (Doctor doctor : doctorList) {
            if (doctor.getName().equals(search) || doctor.getMobileNumber().equals(search)) {
                System.out.println("Doctor found: " + doctor.getName());
                return;
            }
        }
        System.out.println("No doctor found");
    }
    public void ShowAvailableAppointments(){

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void For_Menu(){
        System.out.println("As Patient What to want to do : \n1-> Reserve Appointment\n2-> Cancel Reservation\n3-> Check Prices\n4-> Search for Doctor\n5-> Show Available Appointments ");
        int choice = sc.nextInt();
        switch (choice){
            case 1 -> {
                String date,time;
                System.out.println("Enter date and time for appointment");
                date = sc.nextLine();
                time = sc.nextLine();
               this.reserveAppointment(date,time);
            }
            case 2 -> {
                String date,time;
                System.out.println("Enter date and time to cancel appointment");
                date = sc.nextLine();
                time = sc.nextLine();
                this.cancelReservation(date,time);
            }
            case 3 -> {
                this.checkPrices();
            }
            case 4 -> {
                ArrayList<Doctor> doctorList = new ArrayList<>();
                this.searchForDoctor(doctorList);
            }
            case 5 -> {
                this.ShowAvailableAppointments();
            }
            default -> {
                System.out.println("Invalid choice");
            }
        }
    }



}