package com.project.zeft;


import java.util.ArrayList;

public class Doctor extends User {
    private String doctorName;
    private String specialization;
    private int startHour;
    private int endHour;

    private ArrayList<ArrayList<Integer>> dayHours;
    private ArrayList<ArrayList<Prescription>> patientPrescriptions;
    ArrayList<Integer> appointments;
    private final String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};


    Doctor(String doctorName) {
        super();

    }

    public Doctor(String firstName, String lastName, String username, String email, String password, String mobileNumber, String specialization) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.doctorName = firstName + " " + lastName;
        this.specialization = specialization;
        this.dayHours = new ArrayList<>();
        this.patientPrescriptions = new ArrayList<>();
        initializeSchedule();
    }

    private void initializeSchedule() {
        for (int i = 0; i < 7; i++) {
            dayHours.add(new ArrayList<>());
        }
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void initializePatients(int patientCount) {
        for (int i = 0; i < patientCount; i++) {
            patientPrescriptions.add(new ArrayList<>());
        }
    }

    private int getDayIndex(String day) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].equalsIgnoreCase(day)) {
                return i;
            }
        }
        return -1; // Invalid day
    }

    public void setSchedule(String day, int startHour, int endHour) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Invalid day: " + day);
            return;
        }
        this.startHour = startHour;
        this.endHour = endHour;
        System.out.println("Schedule set for " + day + ": " + startHour + " to " + endHour);
    }

    public void setAppointment(String day, int hour) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Invalid day: " + day);
            return;
        }
        if (hour < startHour || hour >= endHour) {
            System.out.println("Invalid appointment time: " + hour);
            return;
        }
        appointments = dayHours.get(dayIndex);
        if (appointments.contains(hour)) {
            System.out.println("Cannot schedule an appointment at " + hour + " (already booked)");
            return;
        }
        appointments.add(hour);
        System.out.println("Appointment scheduled at " + hour + " on " + day);
    }

    public void cancelAppointment(String day, int hour) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Invalid day: " + day);
            return;
        }
        appointments = dayHours.get(dayIndex);
        if (appointments.remove((Integer) hour)) {
            System.out.println("Appointment at " + hour + " on " + day + " has been canceled.");
        } else {
            System.out.println("No appointment found at " + hour + " on " + day);
        }
    }

    public void showAppointments(String day) {
        int dayIndex = getDayIndex(day);
        if (dayIndex == -1) {
            System.out.println("Invalid day: " + day);
            return;
        }
        appointments = dayHours.get(dayIndex);
        if (appointments.isEmpty()) {
            System.out.println("No appointments for " + day);
        } else {
            System.out.println("Appointments for " + day + ":");
            for (int hour : appointments) {
                System.out.println("- " + hour + ":00");
            }
        }
    }

    /*
        public void receptionistContactInfo(Receptionist receptionist) {
            System.out.println("Receptionist Name: " + receptionist.getName());
            System.out.println("Receptionist Email: " + receptionist.getEmail());
            System.out.println("Receptionist Contact: " + receptionist.getContact());
        }

        public void patientInfo(Patient patient) {
            System.out.println("Patient Name: " + patient.getName());
            System.out.println("Patient Age: " + patient.getAge());
            System.out.println("Patient Email: " + patient.getEmail());
            System.out.println("Patient Contact: " + patient.getContact());
        }
    */
    public void addPrescription(int patientIndex, String medicine, String notes) {
        if (patientIndex < 0 || patientIndex >= patientPrescriptions.size()) {
            System.out.println("Invalid patient index: " + patientIndex);
            return;
        }
        Prescription prescription = new Prescription(this.doctorName);
        prescription.writePrescription(medicine, notes);
        patientPrescriptions.get(patientIndex).add(prescription);
        System.out.println("Prescription added for patient " + (patientIndex + 1));
    }

    public void viewPrescriptions(int patientIndex) {
        if (patientIndex < 0 || patientIndex >= patientPrescriptions.size()) {
            System.out.println("Invalid patient index: " + patientIndex);
            return;
        }
        ArrayList<Prescription> prescriptions = patientPrescriptions.get(patientIndex);
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions for patient " + (patientIndex + 1));
        } else {
            System.out.println("Prescriptions for patient " + (patientIndex + 1) + ":");
            for (Prescription prescription : prescriptions) {
                prescription.printPrescription();
            }
        }
    }

    public static class Prescription {
        private String doctorName;
        private ArrayList<String> medicines;
        private String notes;

        public Prescription(String doctorName) {
            this.doctorName = doctorName;
            this.medicines = new ArrayList<>();
        }

        public void writePrescription(String medicine, String notes) {
            this.medicines.add(medicine);
            this.notes = notes;
        }

        public void printPrescription() {
            System.out.println("Doctor: " + doctorName);
            System.out.println("Medicines: " + String.join(", ", medicines));
            System.out.println("Notes: " + notes);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Doctor's basic information
        sb.append("Doctor Name: ").append(doctorName).append("\n");
        sb.append("Specialization: ").append(specialization).append("\n");

        // Schedule information
        sb.append("Schedule:\n");
        for (int i = 0; i < days.length; i++) {
            sb.append(days[i]).append(": ");
            if (dayHours.get(i).isEmpty()) {
                sb.append("No appointments\n");
            } else {
                sb.append(dayHours.get(i)).append("\n");
            }
        }

        // Patient prescriptions
        sb.append("Patient Prescriptions:\n");
        for (int i = 0; i < patientPrescriptions.size(); i++) {
            sb.append("Patient ").append(i + 1).append(":\n");
            ArrayList<Prescription> prescriptions = patientPrescriptions.get(i);
            if (prescriptions.isEmpty()) {
                sb.append("  No prescriptions\n");
            } else {
                for (Prescription prescription : prescriptions) {
                    sb.append("  - Doctor: ").append(prescription.doctorName).append("\n");
                    sb.append("    Medicines: ").append(String.join(", ", prescription.medicines)).append("\n");
                    sb.append("    Notes: ").append(prescription.notes).append("\n");
                }
            }
        }

        return sb.toString();
    }

}