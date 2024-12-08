package com.project.zeft;

public  class Appointment {
    private String patientName;
    private String date;
    private String time;
    private String PhoneNumber;


    public Appointment(String patientName, String PhoneNumber, String date, String time) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.PhoneNumber = PhoneNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setTime(String time) {
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



    @Override
    public String toString() {
        return "Appointment for " + patientName + " on " + date + " at " + time;
    }
}
