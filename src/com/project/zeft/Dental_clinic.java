package com.project.zeft;
import java.util.ArrayList;
import java.util.Scanner;

public class Dental_clinic {
    private  final String name;
    private  final String location;
    public String  services[]=new String[4];
    public ArrayList <Doctor> doctors =new ArrayList<Doctor>();
    public ArrayList <Patient> patients=new ArrayList<Patient>();
    public ArrayList <Receptionist> receptionists=new ArrayList<Receptionist>();
    private float prices[]=new float[4];
    //⦁ Teeth cleaning
    //⦁ Tooth extractions
    //⦁ Wisdom tooth removal
    //⦁ Children’s dentistry
    {
        this.name="code farmars";
        this.location="Octobar";
        this.services[0]="Teeth cleaning";
        this.services[1]="Tooth extractions";
        this.services[2]="Wisdom tooth removal";
        this.services[3]="Children's dentistry";
        this.prices[0]=65;
        this.prices[1]=100;
        this.prices[2]=150;
        this.prices[3]=200;//intilize final var
    }
    public Dental_clinic(boolean doc,boolean r,boolean p){
        user_type_checker(doc,r,p);
    }

    public ArrayList<Receptionist> getReceptionists() {
        return receptionists;
    }

    public void setReceptionists(ArrayList<Receptionist> receptionists) {
        this.receptionists = receptionists;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }
    public String getLocation() {
        return location;
    }
    public void user_type_checker(boolean is_doctor,boolean is_receptionist,boolean is_patient){
        if (is_doctor)
        {
            doc_menu();
        }
        if(is_receptionist)
        {
            receptionist_menu();
        }
        if (is_patient)
        {
            patient_menu();
        }
    }
    public void doc_menu(){
        int select;
        Scanner input =new Scanner(System.in);
        System.out.println("            Welcome our doctor select what you do       ");
        System.out.println("1_Create new prescription");
        System.out.println("2_Your appointments ");
        System.out.println("3_Get contact information of the receptionist ");
        System.out.println("4_Get Patient Information  ");
        System.out.println("5_Change availability  ");
        System.out.println("Enter your selection : ");
        select=input.nextInt();
        switch (select) {
            case 1:
               ;
                break;
            case 2 :
                Doctor.appointments_date();
                break;
            case 3 :
                receptionists.get(0).getContact_information();
                break;
            case 4 :
                patients.get(0).get_info();
                break;
            case 5 :
                Doctor.availability();
                break;
        }
    }
    public void patient_menu()
    {
        int select;
        Scanner input =new Scanner(System.in);
        System.out.println("What you want to do : ");
        System.out.println("1_Change your Data ");
        System.out.println("2_Reserve an appointment");
        System.out.println("3_Cancel reservation");
        System.out.println("4_Check prices for appointments");
        System.out.println("5_Search for doctor");
        System.out.println("6_Display available appointments for reservation");
        System.out.println("7_Our sevices and prices ");
        select= input.nextInt();

        switch (select)
        {
            case 1 :
                Patient.change_data();
                break;
            case 2 :
                Patient.Reserve_appointment();
                break;
            case 3 :
                Patient.Cancel_reservation();
                break;
            case 4 :
                Patient.Check_prices();
                break;
            case 5 :
                int x;
                System.out.println("1_Search by name : ");
                System.out.println("2_Search by Mobile Number ");
                x=input.nextInt();
                switch (x)
                {
                    case 1 :
                        Patient.Search_for_doctor_name();
                        break;
                    case 2 :
                        Patient.Search_for_doctor_num();
                        break;
                }
            case 6 :
                Doctor.availability();
                break;
            case 7 :
                System.out.println("        our sevices is :    \n");
                for(int i=0;i<4;i++)
                {
                    System.out.printf("%d_%s and it's price is %f\n",i,services[i],prices[i]);
                }


        }
    }
    public void receptionist_menu()
    {
        int select;
        Scanner input =new Scanner(System.in);
        System.out.println("        What you want to do          ");
        System.out.println("1_ Change yor data  ");
        System.out.println("2_Reserve new appointment ");
        System.out.println("3_Cancel reservation for patients  ");
        System.out.println("What you want :  ");
        select=input.nextInt();
        switch (select)
        {
            case 1 :
                Receptionist;
                break;
            case 2 :
                Receptionist.reserve();
                break;
            case 3 :
                Receptionist.cancel();
                break;
        }
    }

}

