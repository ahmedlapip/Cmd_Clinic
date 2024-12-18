package com.project.zeft;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Doctor extends User {
    public static final int PRICE = 400;
    private final String specialization;
    private String curUsername;

    public Doctor(String firstName, String lastName, String username, String email, String password, String mobileNumber, String specialization) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.specialization = specialization;
    }

    public void SetAvailableDays(ArrayList<Appointment> appointmentList) {
        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");
        LocalTime time1 = inputTime("Enter Start Time (HH:MM): ");
        LocalTime time2 = inputTime("Enter End Time (HH:MM): ");

        if (!appointmentList.isEmpty()) {
            for (Appointment appointment : appointmentList) {
                if (appointment.getDate().equals(date) && appointment.getTime().isAfter(time1) && appointment.getTime().isBefore(time2)) {
                    System.out.println("An appointment on " + date + " at " + appointment.getTime() + " already exists.");
                    return;
                }
            }
        }

        for (LocalTime i = time1; i.isBefore(time2) && i.isBefore(LocalTime.parse("23:00")); i = i.plusMinutes(60)) {
            Appointment newAppointment = new Appointment(" ", " ", date, i, this.username, this.getMobileNumber(), "false");
            appointmentList.add(newAppointment);
            System.out.println("Appointment reserved for " + date + " at " + i);
        }
    }

    public void PrescriptionForPatient(ArrayList<Appointment> appointmentList, ArrayList<Prescription> prescriptionList) {

        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointed().equals("true") && appointment.getDate().equals(LocalDate.now())) {
                String Med = input("Enter medicine for the patient: ");
                int dosage = inputInt("Enter number of repetitions: ");
                String notes = input("Enter notes: ");
                curUsername = appointment.getPatientUserName();
                Prescription prescription = new Prescription(curUsername, LocalDate.now(), Med, dosage, notes);
                prescriptionList.add(prescription);
            }
        }
        System.out.println("No patients today doc");
        SystemClear.pause();
    }

    public void ShowForDay(ArrayList<Appointment> appointmentList) {
        boolean f = false;
        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");
        for (Appointment appointment : appointmentList) {
            if (appointment.getDate().equals(date) && appointment.getAppointed().equals("true")) {
                System.out.println("You Have Appointment At " + appointment.getTime());
                f = true;
            }
        }
        if (!f)
            System.out.println("You Have No Appointment At " + date);
    }

    public void changeAvailability(ArrayList<Appointment> appointmentList) {
        int choice = inputInt("\n[1] Create  \n[2] Delete\n");
        boolean f = false;

        do {
            if (choice == 1) {
                SetAvailableDays(appointmentList);
            } else if (choice == 2) {
                showAvailableAppointments(appointmentList);
                LocalDate date = inputDate("Enter date (yyyy-MM-dd)");

                ArrayList<Appointment> toRemove = new ArrayList<>();
                for (Appointment appointment : appointmentList) {
                    if (appointment.getDate().equals(date)
                            && appointment.getAppointed().equals("false")
                            && appointment.getDoctorUserName().equals(username)) {
                        toRemove.add(appointment);
                    }
                }

                for (Appointment appointment : toRemove) {
                    appointmentList.remove(appointment);
                }
                System.out.println("Appointment for " + date + "have been canceled successfully");

            } else {
                System.out.println("Enter valid choice 1 or 2");
                f = true;
            }
        } while (f);
    }

    public String toString() {

        return super.toString() + "," + specialization;
    }

    public static Doctor fromString(String data) {
        String[] parts = data.split(",");
        return new Doctor(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
    }

    public void doctorMenu(ArrayList<Appointment> appointmentList, ArrayList<Receptionist> receptionistList,
                           ArrayList<Patient> patientList, ArrayList<Prescription> prescriptionList) {

        do {
            int choice = inputInt("\n[1] Set Available Days and Hours \n[2] Change Available Day \n[3] Show Your Appointments for Specific day \n[4] Get Contact Information of the receptionist \n[5] Get patient information \n[6] Write Prescription For the Patient \n[0] Back\n");
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> SetAvailableDays(appointmentList);
                case 2 -> changeAvailability(appointmentList);
                case 3 -> ShowForDay(appointmentList);
                case 4 -> getInfoAboutReceptionist(receptionistList);
                case 5 -> getInfoAboutPatient(patientList, appointmentList);
                case 6 -> PrescriptionForPatient(appointmentList, prescriptionList);
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    public void getInfoAboutReceptionist(ArrayList<Receptionist> receptionistList) {
        int i = 1;
        for (Receptionist receptionist : receptionistList) {
            System.out.println("==============================================");
            System.out.println("Receptionist " + i + " Name : " + receptionist.getName()
                    + "\nReceptionist " + i + " Phone Number : " + receptionist.getMobileNumber());
        }
        System.out.println("==============================================");

    }

    public void showAvailableAppointments(ArrayList<Appointment> appointmentList) {
        boolean menu = false;
        for (Appointment appointment : appointmentList) {
            if (appointment.getAppointed().equals("false") && appointment.getDoctorUserName().equals(username)) {
                System.out.println("There is appointments on " + appointment.getDate() + " at " + appointment.getTime());
                menu = true;
            }
        }
        if (!menu)
            System.out.println("there Is No Appointments");
    }

    public void getInfoAboutPatient(ArrayList<Patient> patientList, ArrayList<Appointment> appointmentList) {
        for (Appointment appointment : appointmentList) {
            for (Patient patient : patientList) {
                if (appointment.getPatientUserName().equals(patient.username) && appointment.getAppointed().equals("true") && appointment.getDoctorUserName().equals(this.username)) {

                    System.out.println("====================================");
                    System.out.println("Patient Name: " + patient.getName()
                            + "\nPatient Phone Number: " + patient.getMobileNumber()
                            + "\nPatient Blood Type: " + patient.getBloodType()
                            + "\nPatient Weight: " + patient.getWeight()
                            + "\nPatient Height: " + patient.getHeight()
                            + "\nPatient History: " + patient.getPatientHistory());
                            System.out.println("====================================");
                }
            }
        }
        SystemClear.pause();
    }

}
