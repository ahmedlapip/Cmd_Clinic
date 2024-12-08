package com.project.zeft;

public  class User  {
    protected String firstName="A";
    protected String lastName="B";
    protected String username;
    protected String email;
    protected String password;
    protected String mobileNumber;

    public User(String firstName, String lastName, String username, String email, String password, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
    public User (String Username,String password ){
        this.username=Username;
        this.password=password;
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

    public String getContact() {

        return "";
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
