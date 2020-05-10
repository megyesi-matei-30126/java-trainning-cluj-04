import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestLCD {
    public static void main(String[] args) {
        /**
         * Pentru ca programul sa functioneze bine
         * si pentru o afisare simetrica
         * latimea minimia este 1, iar ianltimea minimia e 3
         * Apoi pentru a testa alte afisari se incrementeasza
         * cu 2 ori latime, ori inaltimea ori amandoua, de cate
         * se doreste.
         */
        List<Byte> digitsList = new ArrayList<>();
        try {
         digitsList = ReadInput.readIntput();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Width: ");
        byte width = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Height: ");
        byte height = scanner.nextByte();
        scanner.nextLine();

        FormLCD formLCD = new FormLCD(width, height);
        for (byte digit : digitsList) {
            formLCD.displayNumberLCD(digit);
        }
    }
}
