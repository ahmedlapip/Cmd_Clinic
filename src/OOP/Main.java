package OOP;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main{
    static ArrayList<Doctor> doctorList;
    static ArrayList<Patient> patientList;
    static ArrayList<Receptionist> receptionistList;

    public static void main(String[] args) throws IOException {

//        doctorList = FileHandler.loadDoctors();
        patientList = FileHandler.loadPatients();
        receptionistList = FileHandler.loadReceptionists();


        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nSaving data before exit...");
//            FileHandler.saveDoctors(doctorList);
            FileHandler.savePatients(patientList);
            FileHandler.saveReceptionists(receptionistList);
        }));



    }
}