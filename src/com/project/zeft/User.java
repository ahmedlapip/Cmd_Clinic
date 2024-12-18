package com.project.zeft;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static final String MOBILE_REGEX = "^(01[0125])\\d{8}$";
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected String mobileNumber;
    int age;
    private String email;

    User() {

    }

    public User(String firstName, String lastName, String username, String email, String password, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidMobileNumber(String mobileNumber) {
        Pattern pattern = Pattern.compile(MOBILE_REGEX);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }

    protected static float inputFloat(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Float.parseFloat(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    public static LocalDate inputDate(String prompt) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = null;

        while (date == null || date.isBefore(LocalDate.now())) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            try {
                date = LocalDate.parse(input, formatter);

                if (date.isBefore(LocalDate.now())) {
                    System.out.println("Date must be today or a future date. Try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }

        return date;
    }

    public static LocalTime inputTime(String prompt,LocalDate date) {

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = null;

        while (time == null || date.isBefore(LocalDate.now())) {
            System.out.println(prompt);
            String input = scanner.nextLine();

            try {
                time = LocalTime.parse(input, timeFormatter); // Parse the input

                if (date.isBefore(LocalDate.now())) {
                    System.out.println("Time must be after the current time. Try again.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid time format. Please use (HH:mm).");
            }
        }
        return time;
    }

    public int getAge() {

        do {
            int age = inputInt("Enter Your Age: ");
            if (age > 8 && age < 90) {
                return age;
            } else {
                System.out.println("Enter Valid Age ");
            }

        } while (true);
    }

    public String setGender(String prompt) {
        String gender = null;
        while (gender == null) { // Keep prompting until valid input is provided
            try {
                System.out.print(prompt);
                gender = scanner.nextLine().trim(); // Get input from the user

                // Check if the input is empty
                if (gender.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please try again.");
                }

                // Validate gender format (Male or Female)
                if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
                    throw new IllegalArgumentException("Invalid gender. Please enter 'Male' or 'Female'.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage()); // Display error message
                gender = null; // Reset input to retry
            }
        }
        return gender;
    }

    public String getPassword() {

        return password;
    }

    public String getUsername() {

        return username;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        if (isValidEmail(email)) {
            System.out.println(email + " is a valid email.");
            this.email = email;
        } else {
            System.out.println(email + " is NOT a valid email.");
        }
    }

    public String getMobileNumber() {

        return mobileNumber;
    }

    protected String setMobileNumber(String prompt) {
        String mobileNumber = null;
        while (mobileNumber == null) { // Keep prompting until valid input is provided
            try {
                System.out.print(prompt);
                mobileNumber = scanner.nextLine().trim(); // Get input from the user

                // Check if the input is empty
                if (mobileNumber.isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please try again.");
                }

                // Validate the mobile number format
                if (!isValidMobileNumber(mobileNumber) || mobileNumber.length() != 11) {
                    throw new IllegalArgumentException("Invalid mobile number. Please enter a valid 11-digit mobile number starting with '01'.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage()); // Display error message
                mobileNumber = null; // Reset input to retry
            }
        }

        return mobileNumber;
    }

    @Override
    public String toString() {
        return firstName + ',' + lastName + ',' + username + ',' + email + ',' + password + ',' + mobileNumber;
    }

    protected String getName() {

        return firstName + ' ' + lastName;
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

            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                userInput = null; // Reset input to retry
            }
        }
        return userInput;
    }

    protected int
    inputInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    protected String inputEmail(String prompt) {
        String userInput = null;
        while (userInput == null) { // Keep prompting until valid input is provided
            try {
                System.out.print(prompt);
                userInput = scanner.nextLine(); // Get input from the user

                // Check if the input is empty
                if (userInput.trim().isEmpty()) {
                    throw new IllegalArgumentException("Input cannot be empty. Please try again.");
                }

                // Validate email format using regex
                if (!Pattern.matches(EMAIL_REGEX, userInput)) {
                    throw new IllegalArgumentException("Invalid email format. Please enter a valid email address.");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage()); // Display error message
                userInput = null; // Reset input to retry
            }
        }
        return userInput;
    }

    public void clear() {
        try {
            // For Windows
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            // For Unix-based systems (Linux/Mac)
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void pause(int num) {
        try {
            // For Windows
            if (System.getProperty("os.name").contains("Windows")) {
                // Simply wait for 2 seconds without showing "Press any key to continue . . ."
                Thread.sleep(num); // Pauses for 2 seconds
            }
            // For Unix-based systems (Linux/Mac)
            else {
                Thread.sleep(num); // Pauses for 2 seconds
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected char inputChar(String prompt) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().toUpperCase();

                // Check if the input is exactly one character
                if (input.length() == 1) {
                    return input.charAt(0);
                } else {
                    System.out.println("Invalid input. Please enter exactly one character.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }



}