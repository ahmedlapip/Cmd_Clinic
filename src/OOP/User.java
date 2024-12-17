package OOP;


import java.io.Console;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class User {
    protected String firstName;
    protected String lastName;
    protected String username;
    private String email;
    protected String password;
    private String mobileNumber;
    private static final Scanner scanner = new Scanner(System.in);

    public User(String firstName, String lastName, String username, String email, String password, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
    public User (String Username,String password ){
        this.username = Username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return  firstName + ',' + lastName + ',' + username + ',' + email + ',' + password + ',' + mobileNumber;
    }

    protected String getName() {
        return firstName + " " + lastName;
    }

    protected String input(String prompt) {
        String userInput = null;
        while (userInput == null) { // Keep prompting until valid input is provided
            try {
                System.out.print(prompt);
                userInput = scanner.nextLine(); // Get input from the user
                if (userInput.trim().isEmpty()) { // Check for empty input
                    throw new IllegalArgumentException("Input cannot be empty. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // Print error message
                userInput = null; // Reset input to retry
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
                userInput = null; // Reset input to retry
            }
        }
        return userInput;
    }


    protected int inputInt(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine()); // Read input and parse it
                valid = true; // Exit loop if parsing succeeds
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }
        return value;
    }

    protected float inputFloat(String prompt) {
        float value = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print(prompt);
                value = Float.parseFloat(scanner.nextLine()); // Parse input as float
                valid = true; // Exit loop if valid float input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred. Please try again.");
            }
        }
        return value;
    }
    public static LocalDate inputDate(String prompt) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;

        while (date == null) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, formatter); // Parse the input
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }

        return date;
    }
    public static LocalTime inputTime(String prompt) {

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = null;

        while (time == null) {
            System.out.println(prompt);
            String input = scanner.nextLine();
            try {
                time = LocalTime.parse(input, timeFormatter); // Parse the input
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use HH:mm.");
            }
        }

        return time;
    }



}