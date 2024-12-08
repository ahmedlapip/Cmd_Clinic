package com.project.zeft;

import java.util.ArrayList;
import java.util.List;

public class Receptionist {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private int age;
    private String gender;

    private List<Appointment> appointments;


    public Receptionist(String username, String password, String firstName, String lastName, String email,
                        String mobileNumber, int age, String gender) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.gender = gender;
        this.appointments = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void updateEmail(String newEmail) {
        setEmail(newEmail);
    }

    public void updateMobileNumber(String newMobileNumber) {
        setMobileNumber(newMobileNumber);
    }


    public String reserveAppointment(String patientName, String date, String time) {
        Appointment newAppointment = new Appointment(patientName, date, time);
        appointments.add(newAppointment);
        return "Appointment reserved for " + patientName + " on " + date + " at " + time + ".";
    }

    public String cancelReservation(String patientName) {

        for (Appointment appointment : appointments) {
            if (appointment.getPatientName().equals(patientName)) {
                appointments.remove(appointment);
                return "Appointment for " + patientName + " has been canceled.";
            }
        }
        return "No appointment found for " + patientName + ".";
    }

    public String viewAppointments() {
        if (appointments.isEmpty()) {
            return "No appointments available.";
        }
        StringBuilder appointmentDetails = new StringBuilder();
        for (Appointment appointment : appointments) {
            appointmentDetails.append(appointment.toString()).append("\n");
        }
        return appointmentDetails.toString();
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }


    public static class Appointment {
        private String patientName;
        private String date;
        private String time;
        Patient patient=new Patient();


        public Appointment(String patientName, String date, String time) {
            this.patientName = patientName;
            this.date = date;
            this.time = time;
        }

        public String getPatientName() {
            return patientName;
        }

        public String getDate() {
            return date;
        }

        public String getTime() {
            return time;
        }
        public void setReservation(){

        }

        @Override
        public String toString() {
            return "Appointment for " + patientName + " on " + date + " at " + time;
        }
    }
}