package OOP;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Press any key:");

        // Read a single character without pressing Enter
        char input = (char) System.in.read();
        System.out.println();

        // Output the character
        System.out.println("You entered: " + input);
    }
}
