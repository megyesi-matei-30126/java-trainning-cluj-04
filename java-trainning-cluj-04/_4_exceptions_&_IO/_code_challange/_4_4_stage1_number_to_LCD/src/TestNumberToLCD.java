import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestNumberToLCD {
    public static void main(String[] args) {
        FormLCD formLCD = new FormLCD();
        List<Byte> digitsList = new ArrayList<>();

        try {
            digitsList = ReadInput.readIntput();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        try {
            formLCD.displayMultipleDigits(digitsList);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
