/*package com.project.zeft;



import java.io.*;
import java.util.ArrayList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public  class FileHandler {
    private static final String DOCTOR_INFO_FILE = "src/main/resources/doctorsinfo.txt";
    private static final String PATIENT_INFO_FILE = "src/main/resources/patientsinfo.txt";
    private static final String RECEPTIONIST_INFO_FILE = "src/main/resources/receptionistsinfo.txt";
    private static final String FILE_NAME = "src/main/resources/records.txt";
    Patient patient = new Patient();






    public static void  saveRecord(int id ,String date, String time) {

        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Write data in the format ID \t Date \t Time
            printWriter.printf("%s\t%s\t%s%n", id, date, time);

            System.out.println("Record saved successfully!");
        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }

















    public static void writePatients(ArrayList<Patient> patientList) throws IOException {
        File file = new File(PATIENT_INFO_FILE);
        if (!file.exists()) {
            System.out.println("the file dose not exist!");
        }
        else{
            FileWriter fr = new FileWriter(PATIENT_INFO_FILE, true);
            PrintWriter pr = new PrintWriter(fr);

            for (Patient patient : patientList) {
                pr.println(patient.toString());
            }
            pr.close();
        }
    }
    public static ArrayList<Patient> readPatients(ArrayList<Doctor> d) throws IOException {



        ArrayList<Patient> patientList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(PATIENT_INFO_FILE));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            Patient patients = new Patient(
                    parts[0], // firstName
                    parts[1], // lastName
                    parts[2], // username
                    parts[3], // email
                    parts[4], // password
                    parts[5], // mobileNumber
                    parts[6], // age
                    parts[7], // gender
                    Float.parseFloat(parts[8]), // weight
                    Float.parseFloat(parts[9])  // height
            );
            patientList.add(patients);
        }
        br.close();
        return patientList;
    }
    public static void writeReceptionist(ArrayList <Receptionist> receptionistsList) throws IOException {
        File file = new File(RECEPTIONIST_INFO_FILE);
        if (!file.exists()) {
            System.out.println("the file dose not exist!");
        }
        else{
            FileWriter fr = new FileWriter(RECEPTIONIST_INFO_FILE, true);
            PrintWriter pr = new PrintWriter(fr);

            for (Receptionist receptionist : receptionistsList) {
                pr.println(receptionist.toString());
            }
            pr.close();
        }
    }
    public static void writeDoctors(ArrayList<Doctor> doctorList) throws IOException {
        File file = new File(DOCTOR_INFO_FILE);
        if (!file.exists()) {
            System.out.println("the file dose not exist!");
        }
        else {
            try (FileWriter fr = new FileWriter(DOCTOR_INFO_FILE, true);
                 PrintWriter pr = new PrintWriter(fr)) {
                for (Doctor doctor : doctorList) {
                    pr.println(doctor.toString());
                }
            }
        }
    }
    public static ArrayList<Doctor> readDoctors() throws IOException {
        ArrayList <Doctor> doctorList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(DOCTOR_INFO_FILE));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            Doctor doctors = new Doctor(
                    parts[0], // firstName
                    parts[1], // lastName
                    parts[2], // username
                    parts[3], // email
                    parts[4], // password
                    parts[5], // mobileNumber
                    parts[6]  // specialization
            );
            doctorList.add(doctors);
        }
        br.close();
        return doctorList;
    }
    public static ArrayList<Receptionist> readReceptionists() throws IOException {
        ArrayList<Receptionist> receptionistList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(RECEPTIONIST_INFO_FILE));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(","); // Assuming comma-separated values
            Receptionist receptionists = new Receptionist(
                    parts[0], // firstName
                    parts[1], // lastName
                    parts[2], // username
                    parts[3], // email
                    parts[4], // password
                    parts[5], // mobileNumber
                    parts[6], // age
                    parts[7]  // gender
            );
            receptionistList.add(receptionists);
        }
        br.close();
        return receptionistList;
    }

    public static void writeDoctorActivities(ArrayList<String> activitiesList) throws IOException {
        FileWriter fr = new FileWriter("doctor_activities.txt", true);
        PrintWriter pr = new PrintWriter(fr);

        for (String activity : activitiesList) {
            pr.println(activity);
        }
        pr.close();
    }

    public static void writePatientActivities(ArrayList<String> activitiesList) throws IOException {
        FileWriter fr = new FileWriter("patient_activities.txt", true);
        PrintWriter pr = new PrintWriter(fr);

        for (String activity : activitiesList) {
            pr.println(activity);
        }
        pr.close();
    }

    public static void writeReceptionistActivities(ArrayList<String> activitiesList) throws IOException {
        FileWriter fr = new FileWriter("receptionist_activities.txt", true);
        PrintWriter pr = new PrintWriter(fr);

        for (String activity : activitiesList) {
            pr.println(activity);
        }
        pr.close();
    }
    public static ArrayList<String> readDoctorActivities() throws IOException {
        ArrayList<String> doctoractivitiesList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("doctor_activities.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            doctoractivitiesList.add(line);
        }
        br.close();
        return doctoractivitiesList;
    }
    public static ArrayList<String> readPatientActivities() throws IOException {
        ArrayList<String> patientactivitiesList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("patient_activities.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            patientactivitiesList.add(line);
        }
        br.close();
        return patientactivitiesList;
    }

    public static ArrayList<String> readReceptionistActivities() throws IOException {
        ArrayList<String> receptionistactivitiesList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("receptionist_activities.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            receptionistactivitiesList.add(line);
        }
        br.close();
        return receptionistactivitiesList;
    }
}



*/


