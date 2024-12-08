package OOP;

public class Receptionist extends User {
    String gender;
    int age;
    public Receptionist(String firstName, String lastName, String username, String email, String password,
                        String mobileNumber, String gander, int age){

        super(firstName, lastName, username, email, password, mobileNumber);
        this.age = age;
        this.gender = gander;
    }
    public Receptionist(String username, String password) {
        super(username, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void receptionistMenu(){

        System.out.println("patient");
    }

    @Override
    public String toString() {
        return  super.toString() + "," + gender + ',' + age;
    }
    public static Receptionist fromString(String data) {
       String[] parts = data.split(",");
        String firstName = parts[0];
        String lastName = parts[1];
        String username = parts[2];
        String email = parts[3];
        String password = parts[4];
        String mobileNumber = parts[5];
        String gender = parts[6];
        int age = Integer.parseInt(parts[7]);
        return new Receptionist(firstName, lastName, username, email, password, mobileNumber, gender, age);
    }
}
