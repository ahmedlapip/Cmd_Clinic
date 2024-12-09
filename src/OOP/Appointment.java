package OOP;

import java.io.*;
import java.util.ArrayList;

public class Appointment {
    private String patientName;
    private String date;
    private String time;
    private String phoneNumber;

    // Constructor
    public Appointment(String patientName, String phoneNumber, String date, String time) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    // Convert Appointment object to a string
    @Override
    public String toString() {
        return patientName + "," + phoneNumber + "," + date + "," + time;
    }

    // Convert a string back to an Appointment object
    public static Appointment fromString(String line) {
        String[] fields = line.split(",");
        if (fields.length != 4) {
            throw new IllegalArgumentException("Invalid appointment data: " + line);
        }
        return new Appointment(fields[0], fields[1], fields[2], fields[3]);
    }

    // Save a list of appointments to a file
    public static void saveAppointments(ArrayList<Appointment> appointmentList, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Appointment appointment : appointmentList) {
                writer.write(appointment.toString() + "\n");
            }
            System.out.println("Appointments saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load appointments from a file
    public static ArrayList<Appointment> loadAppointments(String fileName) {
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                appointmentList.add(Appointment.fromString(line));
            }
            System.out.println("Appointments loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appointmentList;
    }
}
