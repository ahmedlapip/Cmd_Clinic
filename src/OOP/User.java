package OOP;


import java.util.Scanner;

public  class User {
    private String firstName;
    private String lastName;
    protected String username;
    private String email;
    protected String password;
    private String mobileNumber;
    private final Scanner scanner = new Scanner(System.in);

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
        System.out.print(prompt);
        return scanner.nextLine();
    }

    protected int inputInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return value;
    }

    protected float inputFloat(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextFloat()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        float value = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        return value;
    }

}