package OOP;import java.time.LocalDate;import java.time.LocalTime;import java.util.ArrayList;import java.util.Scanner;public class Patient extends User {    protected String patientHistory, age, gender, bloodType;    protected float weight = 0;    protected float height = 0;    private final Scanner sc = new Scanner(System.in);    // Constructors    public Patient() {}    public Patient(String userName, String password) {        super(userName, password);    }    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber) {        super(firstName, lastName, username, email, password, mobileNumber);    }    public Patient(String firstName, String lastName, String username, String email, String password, String mobileNumber,                   String age, String gender, String bloodType, String patientHistory, float weight, float height) {        super(firstName, lastName, username, email, password, mobileNumber);        this.age = age;        this.gender = gender;        this.weight = weight;        this.height = height;        this.bloodType = bloodType;        this.patientHistory = patientHistory;    }    // Update Patient Information    public void updateInfo() {        boolean r=false;do {        String choice = input("What do you want to change? (Email, Mobile Number, Weight, Height) : ");        switch (choice.toLowerCase()) {            case "email" -> {               setEmail(input("Enter new email: "));            }            case "mobile number" -> {               setMobileNumber(input("Enter new mobile number: "));            }            case "weight" -> {              weight= inputFloat("Enter new weight: ");               // Clear newline character            }            case "height" -> {               height= inputFloat("Enter new height: ");                // Clear newline character            }            default -> {                System.out.println("Do You want to change the values?");                r=true;            }        }        }while (r);    }    // Reserve Appointment    public void reserveAppointment(ArrayList<Appointment> appointmentList) {        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");        LocalTime time = inputTime("Enter time (HH:MM): ");        for (Appointment appointment : appointmentList) {            if (appointment.getDate().equals(date) && appointment.getTime().equals(time)) {                System.out.println("An appointment on " + date + " at " + time + " already exists.");                return;            }            else {                appointment.setPatient_U_Name(this.username);                appointment.setPhoneNumber(super.getMobileNumber());                appointment.setAppointed("true");                System.out.println("Appointment reserved for " + date + " at " + time);                return;            }        }    }    // Cancel Appointment    public void cancelReservation(ArrayList<Appointment> appointmentList) {        LocalDate date = inputDate("Enter date(yyyy-MM-dd)");        LocalTime time = inputTime("Enter time (HH:MM): ");        for (Appointment appointment : appointmentList) {            if (appointment.getDate().equals(date) && appointment.getTime().equals(time) && appointment.getPhoneNumber().equals(getMobileNumber())) {                appointmentList.remove(appointment);                System.out.println("Appointment on " + date + " at " + time + " has been canceled.");                return;            }        }        System.out.println("No appointment found for " + date + " at " + time + ".");    }    // Check Appointment Prices    public void checkPrices( ArrayList<Appointment> appointmentList) {        for (Appointment appointment : appointmentList) {            int count = appointmentList.size();            if (count > 0 && appointment.getPatient_U_Name().equals(this.getUsername())) {                System.out.println("You have " + count + " appointment(s).");                System.out.println("Total price: " + count * Doctor.PRICE + " EGP");            } else {                System.out.println("No appointments found.");            }        }    }    // Search for Doctor    public void searchForDoctor(ArrayList<Doctor> doctorList) {        String search = input("Enter doctor name or mobile number: ");        for (Doctor doctor : doctorList) {            if (doctor.getName().equalsIgnoreCase(search) || doctor.getMobileNumber().equals(search)) {                System.out.println("Doctor found");                System.out.println("======================================");                System.out.println("Doctor Name: " + doctor.getName());                System.out.println("Doctor Mobile Number: " + doctor.getMobileNumber());                System.out.println("Doctor Email: " + doctor.getEmail());                System.out.println("======================================");                return;            }        }        System.out.println("No doctor found.");    }    public String toString() {        return super.toString() + "," + patientHistory + "," + bloodType + "," + gender + "," + age + "," + weight + "," + height;    }    public static Patient fromString(String data) {        String[] parts = data.split(",");        return new Patient(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], Float.parseFloat(parts[10]), Float.parseFloat(parts[11]));    }    // Display Available Appointments (To be implemented)    public void showAvailableAppointments(ArrayList<Appointment> appointmentList) {        for (Appointment appointment : appointmentList) {            if(appointment.getPatient_U_Name().equals(this.username) && (appointment.getAppointed().equals("true"))){                System.out.println("there Is available Appointment On "+ appointment.getDate() +" at " +appointment.getTime());            }            else {                System.out.println("there Is No Appointments");            }        }    }    // Getter and Setter Methods    public String getAge() {        return age;    }    public void setAge(String age) {        this.age = age;    }    public String getBloodType() {        return bloodType;    }    public void setBloodType(String bloodType) {        this.bloodType = bloodType;    }    public float getHeight() {        return height;    }    public void setHeight(float height) {        this.height = height;    }    public float getWeight() {        return weight;    }    public String getPatientHistory() {        return patientHistory;    }    public void setPatientHistory(String patientHistory) {        this.patientHistory = patientHistory;    }    public String getGender() {        return gender;    }    public void setGender(String gender) {        this.gender = gender;    }    public void setWeight(float weight) {        this.weight = weight;    }    // Interactive Menu for Patientspublic void patientMenu(ArrayList<Doctor> doctorList,ArrayList<Appointment> appointmentList) {    boolean For_menu=false;    do{        int choice =inputInt("""        =================================        Choose an option:        1 -> Reserve Appointment        2 -> Cancel Reservation        3 -> Check Prices        4 -> Search for Doctor        5 -> Show Available Appointments        6 -> Update Information        =================================""");        switch (choice) {            case 1 -> reserveAppointment(appointmentList);            case 2 -> cancelReservation(appointmentList);            case 3 -> checkPrices(appointmentList);            case 4 -> searchForDoctor(doctorList);            case 5 -> showAvailableAppointments(appointmentList);            case 6 -> updateInfo();            default -> System.out.println("Invalid choice. Please try again.");        }    }while(For_menu);}}