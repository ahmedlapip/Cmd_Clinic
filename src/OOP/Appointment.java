package OOP;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Appointment {
    private String patient_U_Name;
    private LocalDate date;
    private LocalTime time;
    private String phoneNumber;
    private String doctor_U_Name;
    private String Appointed ="false";
    private String doctorNum;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
// Constructor

    public String getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(String doctorNum) {
        this.doctorNum = doctorNum;
    }

    public Appointment(String patient_U_Name, String phoneNumber, LocalDate date, LocalTime time, String doctor_U_Name, String doctorNum, String Appointed) {
        this.patient_U_Name = patient_U_Name;
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
        this.doctor_U_Name = doctor_U_Name;
        this.Appointed = Appointed;
        this.doctorNum=doctorNum;

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




    public String getDoctor_U_Name() {
        return doctor_U_Name;
    }

    public void setDoctor_U_Name(String doctor_U_Name) {
        this.doctor_U_Name = doctor_U_Name;
    }

    public String getPatient_U_Name() {
        return patient_U_Name;
    }

    public void setPatient_U_Name(String patient_U_Name) {
        this.patient_U_Name = patient_U_Name;
    }


    // Convert Appointment object to a string
    @Override
    public String toString() {
        return patient_U_Name + "," + phoneNumber + "," + date + "," + time;
    }

    // Convert a string back to an Appointment object
    public static Appointment fromString(String line) {
        String[] fields = line.split(",");
        try {

            // Return a new Appointment object
            return new Appointment( fields[0],
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
