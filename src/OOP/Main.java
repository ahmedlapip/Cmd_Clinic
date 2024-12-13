package OOP;

import java.io.IOException;
import java.util.ArrayList;

public class Main{
    static ArrayList<Doctor> doctorList = new ArrayList<>();
    static ArrayList<Patient> patientList= new ArrayList<>();
    static ArrayList<Receptionist> receptionistList= new ArrayList<>();
    static ArrayList<Appointment> appointmentList= new ArrayList<>();
    static Dental_clinic dental_clinic= new Dental_clinic();
    public static void main(String[] args) throws IOException {

    FileHandler.loadEntity(doctorList,patientList,receptionistList,appointmentList);
    dental_clinic.showMenu(doctorList,patientList,receptionistList,appointmentList);
    FileHandler.saveEntity(doctorList,patientList,receptionistList,appointmentList);

    }
}