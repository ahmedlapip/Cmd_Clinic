package com.project.zeft;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Appointment {
    private String patientUserName;
    private final LocalDate date;
    private final LocalTime time;
    private String phoneNumber;
    private final String doctorUserName;
    private String Appointed;
    private final String doctorNum;


    public Appointment(String patientUserName, String phoneNumber, LocalDate date, LocalTime time, String doctorUserName, String doctorNum, String Appointed) {
        this.patientUserName = patientUserName;
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
        this.doctorUserName = doctorUserName;
        this.Appointed = Appointed;
        this.doctorNum = doctorNum;

    }

    public LocalDate getDate() {

        return date;
    }

    public LocalTime getTime() {

        return time;
    }

    public String getDoctorNum() {

        return doctorNum;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getAppointed() {

        return Appointed;
    }

    public void setAppointed(String appointed) {

        Appointed = appointed;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getDoctorUserName() {

        return doctorUserName;
    }

    public String getPatientUserName() {

        return patientUserName;
    }

    public void setPatientUserName(String patientUserName) {

        this.patientUserName = patientUserName;
    }

    @Override
    public String toString() {

        return patientUserName + "," + phoneNumber + "," + date + "," + time + "," + doctorUserName + "," + doctorNum + "," + Appointed;
    }

    public static Appointment fromString(String line) {
        String[] fields = line.split(",");
        try {

            return new Appointment(fields[0],
                    fields[1],
                    LocalDate.parse(fields[2], DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    LocalTime.parse(fields[3], DateTimeFormatter.ofPattern("HH:mm")),
                    fields[4],
                    fields[5],
                    fields[6]);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date or time format.", e);
        }
    }

}