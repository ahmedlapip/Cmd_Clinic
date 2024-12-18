package com.project.zeft;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Prescription> prescriptions = new ArrayList<>();
        ArrayList<Receptionist> receptionists = new ArrayList<>();
        ArrayList<Appointment> appointments = new ArrayList<>();

        Dental_clinic clinic = new Dental_clinic();
        FileHandler.loadEntity(doctors, patients, receptionists, appointments, prescriptions);
        clinic.showMenu(doctors, patients, receptionists, appointments, prescriptions);
    }
}