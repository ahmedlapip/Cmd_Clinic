 
 /* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.zeft;
import java.util.ArrayList;

/**
 *
 * @author Mohamed
 */
class SignUp {
     String username;
     String firstname;
     String lastname;
     String e_mail;
     private String password;
     Long phone;
     int  available_days;//doc
     double  available_hours;//doc
     String patient_history;//patient
     String blood_type;//Patient
     String gender;//Patient //Receptionist
     int age; //Patient//Receptionist
     double weight;//Patient
     double height;//Patient
     ArrayList<Object> list =new ArrayList <>();

    public SignUp() {
    }
     

    public SignUp(String username,  String firstname,String lastname,String e_mail, String password, Long phone) {
        this.username=username;
        this.firstname=firstname;
        this.lastname=lastname;
        this.e_mail = e_mail;
        this.password = password;
        this.phone = phone;
        //general
            }
      
      
    public SignUp(String username,  String firstname,String lastname,String e_mail, String password, Long phone,String patient_history,String blood_type,String gender,int age, double weight,double height){
    this( username,firstname,lastname, e_mail, password,phone);
    this.patient_history= patient_history;
    this.blood_type=blood_type;
    this.gender=gender;
    this.age=age;
    this.weight=weight;
    this.height=height;
    //for patiant
    }
   /* public void set_patient()
    {
        
    }*/
    
 public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        list.add(username);
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
        list.add(firstname);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
        list.add(lastname);
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
        list.add(e_mail);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        list.add(password);
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
        list.add(phone);
    }

    public String getPatient_history() {
        return patient_history;
    }

    public void setPatient_history(String patient_history) {
        this.patient_history = patient_history;
        list.add(patient_history);
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
        list.add(blood_type);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        list.add(gender);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        list.add(age);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
        list.add(weight);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
        list.add(height);
    }

   

     public SignUp (String username, String firstname,String lastname,String e_mail, String password, Long phone,int  available_days, double  available_hours)
   {
    this( username,firstname,lastname, e_mail, password,phone);
   this.available_days=available_days;
   this.available_hours=available_hours;
    //for doctor
   }

    public int getAvailable_days_doc() {
        return available_days;
    }

    public void setAvailable_days_doc(int available_days) {
        this.available_days = available_days;
        list.add(available_days);
    }

    public double getAvailable_hours_doc() {
        return available_hours;
    }

    public void setAvailable_hours_doc(double available_hours) {
        this.available_hours = available_hours;
        list.add(available_hours);
    }

       
public SignUp(String username,  String firstname,String lastname,String e_mail, String password, Long phone,String gender,int age)
{
 this( username,firstname,lastname, e_mail, password,phone);
this.gender=gender;
 this.age=age;
 
 //for Receptionist
}
   public String getGender_Receptionist() {
        return gender;
    }

    public void setGender_Receptionist(String gender) {
        this.gender = gender;
        list.add(gender);
    }

    public int getAge_Receptionist() {
        return age;
    }

    public void setAge_Receptionist(int age) {
        this.age = age;
        list.add(age);
    }

}