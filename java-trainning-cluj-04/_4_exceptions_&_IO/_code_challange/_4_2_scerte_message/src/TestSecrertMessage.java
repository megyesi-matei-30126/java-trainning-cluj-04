import java.io.IOException;

public class TestSecrertMessage {
    public static void main(String[] args) {
        System.out.print("Secret message is: ");
        try {
            System.out.print(ReadFile.readFile());
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
