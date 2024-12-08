package com.project.zeft;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;



public class Patient extends User {
protected String patientHistory, age, gender, bloodType;
protected float weight=0;
protected float height=0;
Scanner sc = new Scanner(System.in);

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


    public void checkPrices(){
     //  System.out.println("you Have Appointments on "+" "+);

    }

    public void searchForDoctor(){

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



}