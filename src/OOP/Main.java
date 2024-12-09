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
    static ArrayList<Appointment> appointmentList;
static SignUp signUp = new SignUp();
    public static void main(String[] args) throws IOException {

        doctorList = FileHandler.loadDoctors();
        patientList = FileHandler.loadPatients();
        receptionistList = FileHandler.loadReceptionists();
        appointmentList=FileHandler.loadAppointments();
        signUp.signUp(patientList,doctorList,receptionistList,appointmentList);

FileHandler.saveDoctors(doctorList);
FileHandler.savePatients(patientList);
FileHandler.saveReceptionists(receptionistList);
FileHandler.saveAppointments(appointmentList);







    }
}