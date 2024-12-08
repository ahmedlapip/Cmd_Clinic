package OOP;

import java.util.ArrayList;

class SignUp extends User {

     private String availableDays;
     private String availableHours;
     private String patientHistory;
     private String bloodType;
     private String gender;
     private String age;
    private int rage;

    private float weight, height;

    public SignUp(String firstname, String lastname, String username, String email, String password,
                  String mobilenumber, String availableDays, String availableHours,  ArrayList<Doctor> doctorList) {
        super(firstname, lastname, username, password, email, mobilenumber);
        this.availableDays = availableDays;
        this.availableHours = availableHours;
        doctorList.add(new Doctor(firstname, lastname, username, email, password, mobilenumber, availableDays, availableHours));
    }

    public SignUp(String firstname, String lastname, String username, String email, String password, String mobilenumber,
                  String patientHistory, String bloodType, String gender,String age, float weight, float height, ArrayList<Patient> patientList) {
        super(firstname, lastname, username, password, email, mobilenumber);
        this.patientHistory = patientHistory;
        this.bloodType = bloodType;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.height = height;
        //patient
        patientList.add(new Patient(firstname, lastname, username, password, email, mobilenumber, patientHistory, bloodType, gender, age, weight, height));
    }

    public SignUp(String firstname, String lastname, String username, String email, String password,
                  String mobilenumber, String gander, int rage, ArrayList<Receptionist> receptionistList) {
        super(firstname, lastname, username, password, email, mobilenumber);
        this.gender = gander;
        this.rage = rage;
        receptionistList.add(new Receptionist(firstname, lastname, username, email, password, mobilenumber, gander, rage));
    }

    public String getUsername() {
         return username;
     }

     public void setUsername(String username) {
         this.username = username;
     }


     public String getPatient_history() {
         return patientHistory;
     }

     public void setPatient_history(String patientHistory) {
         this.patientHistory = patientHistory;
     }

     public String getBlood_type() {
         return bloodType;
     }

     public void setBlood_type(String blood_type) {
         this.bloodType = blood_type;
     }

     public String getGender() {
         return gender;
     }

     public void setGender(String gender) {
         this.gender = gender;
     }

     public String getAge() {
         return age;
     }

     public void setAge(String age) {
         this.age = age;
     }

     public float getWeight() {
         return weight;
     }

     public void setWeight(float weight) {
         this.weight = weight;
     }

     public float getHeight() {
         return height;
     }

     public void setHeight(float height) {
         this.height = height;
     }
     public String getAvailable_days() {
         return availableDays;
     }

     public void setAvailable_days(String available_days) {
         this.availableDays = available_days;
     }

     public String getAvailableHours() {
         return availableHours;
     }

     public void setAvailableHours(String availableHours) {
         this.availableHours = availableHours;
     }

     public String getGender_Receptionist() {
         return gender;
     }

     public void setGender_Receptionist(String gender) {
         this.gender = gender;
     }

     public String getAge_Receptionist() {
         return age;
     }

     public void setAge_Receptionist(String age) {
         this.age = age;
     }

 }