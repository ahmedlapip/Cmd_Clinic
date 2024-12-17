package OOP;

import java.util.ArrayList;
import java.util.Scanner;

public class Dental_clinic extends SignUp {
    private final String Name;
    private final String Location;
    private final String ContactNumber;
    private final String Email;
    private ArrayList<String> services;
    private ArrayList<Integer> prices;
    private static int servics_index = 4;
    static SignUp signUp = new SignUp();
    // Default constructor
    public Dental_clinic() {
        this.Name = "Smile Craft Dental Clinic";
        this.Location = "Cairo, Egypt";
        this.ContactNumber = "+20 123 456 789";
        this.Email = "contact@smilecraftclinic.com";
        this.services = new ArrayList<>();
        this.prices = new ArrayList<>();

        // Default services and prices
        this.prices.add(0, 100); // Teeth cleaning
        this.prices.add(1, 200); // Tooth extractions
        this.prices.add(2, 300); // Wisdom tooth removal
        this.prices.add(3, 400); // Children's dentistry

        this.services.add(0, "Teeth cleaning");
        this.services.add(1, "Tooth extractions");
        this.services.add(2, "Wisdom tooth removal");
        this.services.add(3, "Children's dentistry");

        System.out.println("Welcome to Smile Craft Dental Clinic");
        displayClinicInfo(); // Show clinic info when created
    }

    // Display clinic information
    public void displayClinicInfo() {
        System.out.println("\n--- Clinic Information ---");
        System.out.println("Clinic Name: " + this.Name);
        System.out.println("Location: " + this.Location);
        System.out.println("Contact Number: " + this.ContactNumber);
        System.out.println("Email: " + this.Email);
        System.out.println("---------------------------");
    }

    // Add new service to the clinic
    public void addService(Scanner in) {
        String newService;
        int newPrice;

        // Ask for service name
        System.out.println("Enter new service name: ");
        in.nextLine(); // Consume newline
        newService = in.nextLine();

        // Ask for service price
        System.out.println("Enter price for " + newService + ": ");
        newPrice = in.nextInt();

        this.services.add(servics_index, newService);
        this.prices.add(servics_index, newPrice);

        servics_index++;
        System.out.println("Service added successfully!");
    }

    // Get the list of all services in the clinic
    public ArrayList<String> getListOfServices() {
        return services;
    }

    // Get the price of a service
    public ArrayList<Integer> getPrices() {
        return prices;
    }

    // Get the location of the clinic
    public String getLocation() {
        return Location;
    }

    // Get the name of the clinic
    public String getName() {
        return Name;
    }

    // Set menu to show available options
    public void showMenu(ArrayList<Doctor> doctorList, ArrayList<Patient> patientList, ArrayList<Receptionist> receptionistList, ArrayList<Appointment> appointmentList) {

        int choice;
        boolean running = true;

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View Services");
            System.out.println("2. View Clinic Information");
            System.out.println("3. Log In or Sign Up");
            System.out.println("4. Exit");

            choice = inputInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    viewServices();
                    break;
                case 2:
                    displayClinicInfo();
                    break;
                case 3:
                    signUp.Sign_Up(patientList,doctorList,receptionistList,appointmentList);
                    break;
                case 4:
                    System.out.println("Thank you for visiting Smile Craft Dental Clinic!");
                    running = false;
                    FileHandler.saveEntity(doctorList,patientList,receptionistList,appointmentList);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // View all available services and prices
    private void viewServices() {
        System.out.println("\n--- Available Services ---");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i + 1) + ". " + services.get(i) + " - Price: " + prices.get(i) + " EGP");
        }
        System.out.println("---------------------------");
    }

}
