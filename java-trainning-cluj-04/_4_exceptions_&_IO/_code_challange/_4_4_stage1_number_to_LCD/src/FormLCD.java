import java.io.IOException;
import java.util.*;

public class FormLCD {
    private Map<Byte, String[]> numberForm;
    private List<String> finalForm;

    static String form1;
    static String form2;
    static String form3;
    static String form4;
    static String form6;
    static String form7;


    public FormLCD() {
        this.numberForm = new HashMap<>();
        this.finalForm = new ArrayList<>();

        //Facem toate posibilitatile de scriere pe o singura linie
        form1 = " _ ";
        form2 = "  |";
        form3 = " _|";
        form4 = "|_ ";
        form6 = "| |";
        form7 = "|_|";

        constructForm();
    }

    public void constructForm() {
        this.numberForm.put((byte) 0, new String[]{form1, form6, form7});
        this.numberForm.put((byte) 1, new String[]{"   ", form2, form2});
        this.numberForm.put((byte) 2, new String[]{form1, form3, form4});
        this.numberForm.put((byte) 3, new String[]{form1, form3, form3});
        this.numberForm.put((byte) 4, new String[]{"   ", form7, form2});
        this.numberForm.put((byte) 5, new String[]{form1, form4, form3});
        this.numberForm.put((byte) 6, new String[]{form1, form4, form7});
        this.numberForm.put((byte) 7, new String[]{form1, form2, form2});
        this.numberForm.put((byte) 8, new String[]{form1, form7, form7});
        this.numberForm.put((byte) 9, new String[]{form1, form7, form2});
    }

    public void displayMultipleDigits(List<Byte> digisOfNumber) throws IOException {
        String[][] matrix = new String[3][digisOfNumber.size()];
        StringBuilder sb = new StringBuilder();
        byte j = 0;
        for (byte digit : digisOfNumber) {
            byte i = 0;
            if (this.numberForm.containsKey(digit)) {
                String[] formDigit = this.numberForm.get(digit);
                for (String form : formDigit) {
                    matrix[i][j] = form;
                    i++;
                }
            }
            j++;
        }
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < digisOfNumber.size(); k++) {
                System.out.print(matrix[i][k] + "   ");
                sb.append(matrix[i][k]).append("   ");
            }
            System.out.println();
            sb.append('\n');
            WriteInput.writeLCD(sb.toString());
        }
    }
}
