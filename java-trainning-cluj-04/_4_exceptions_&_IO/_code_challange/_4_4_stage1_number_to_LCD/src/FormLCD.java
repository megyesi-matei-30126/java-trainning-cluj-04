import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        this.numberForm.put((byte) 0, new String[]{"Number 0" , form1, form6, form7});
        this.numberForm.put((byte) 1, new String[]{"Number 1" ,form2, form2});
        this.numberForm.put((byte) 2, new String[]{"Number 2" ,form1, form3, form4});
        this.numberForm.put((byte) 3, new String[]{"Number 3", form1, form3, form3});
        this.numberForm.put((byte) 4, new String[]{"Number 4" ,form7, form2});
        this.numberForm.put((byte) 5, new String[]{"Number 5", form1, form4, form3});
        this.numberForm.put((byte) 6, new String[]{"Number 6", form1, form4, form7});
        this.numberForm.put((byte) 7, new String[]{"Number 7", form1, form2, form2});
        this.numberForm.put((byte) 8, new String[]{"Number 8", form1, form7, form7});
        this.numberForm.put((byte) 9, new String[]{"Number 9", form1, form7, form2});
    }

    public void displayNumberLCD(byte digit) {
        if (this.numberForm.containsKey(digit)) {
            String[] formStrings = this.numberForm.get(digit);
            byte i = 0;
            for (String form : formStrings) {
                //System.out.println(form);
                this.finalForm.add(form);
                try {
                    WriteInput.writeLCD(this.finalForm);
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                }
            }
        }
    }
}
