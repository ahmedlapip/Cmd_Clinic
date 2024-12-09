package OOP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Doctor extends User {
    public static final int PRICE = 400;
    private String doctorName;
    private String specialization;
    private int startHour;
    private int endHour;

    // Stores available hours for each day of the week
    private List<List<Integer>> dayHours;
    // Maps patient IDs to their prescriptions
    private Map<Integer, List<Prescription>> patientPrescriptions;

    private final String[] days = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public Doctor(String firstName, String lastName, String username, String email, String password, String mobileNumber, String specialization) {
        super(firstName, lastName, username, email, password, mobileNumber);
        this.doctorName = firstName + " " + lastName;
        this.specialization = specialization;
        this.dayHours = new ArrayList<>();
        this.patientPrescriptions = new HashMap<>();
        initializeSchedule();
    }

    public Doctor(String firstname, String lastname, String username, String email, String password, String mobileNumber, String availableDays, String availableHours, String specialization) {
    }

    public static Doctor fromString(String line) {
        String[] parts = line.split(",");
        String firstName = parts[0];
        String lastName = parts[1];
        String username = parts[2];
        String email = parts[3];
        String password = parts[4];
        String mobileNumber = parts[5];
        String specialization = parts[6];
        return new Doctor(firstName, lastName, username, email, password, mobileNumber, specialization);
    }

    // Initializes the schedule structure
    private void initializeSchedule() {
        for (int i = 0; i < 7; i++) {
            dayHours.add(new ArrayList<>());
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
        List<Integer> appointments = dayHours.get(dayIndex);
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
        List<Integer> appointments = dayHours.get(dayIndex);
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
        List<Integer> appointments = dayHours.get(dayIndex);
        if (appointments.isEmpty()) {
            System.out.println("No appointments for " + day);
        } else {
            System.out.println("Appointments for " + day + ":");
            for (int hour : appointments) {
                System.out.println("- " + hour + ":00");
            }
        }
    }

    public void initializePatients(int patientCount) {
        for (int i = 0; i < patientCount; i++) {
            patientPrescriptions.put(i, new ArrayList<>());
        }
    }

    public void addPrescription(int patientId, String medicine, String notes) {
        if (!patientPrescriptions.containsKey(patientId)) {
            System.out.println("Invalid patient ID: " + patientId);
            return;
        }
        Prescription prescription = new Prescription(this.doctorName);
        prescription.writePrescription(medicine, notes);
        patientPrescriptions.get(patientId).add(prescription);
        System.out.println("Prescription added for patient ID " + patientId);
    }

    public void viewPrescriptions(int patientId) {
        if (!patientPrescriptions.containsKey(patientId)) {
            System.out.println("Invalid patient ID: " + patientId);
            return;
        }
        List<Prescription> prescriptions = patientPrescriptions.get(patientId);
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions for patient ID " + patientId);
        } else {
            System.out.println("Prescriptions for patient ID " + patientId + ":");
            for (Prescription prescription : prescriptions) {
                prescription.printPrescription();
            }
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

        return sb.toString();
    }

    public static class Prescription {
        private String doctorName;
        private List<String> medicines;
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
}
