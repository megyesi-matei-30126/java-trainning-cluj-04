import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormLCD {
    private byte width;
    private byte height;
    private Map<Byte, String[]> numberForm;

    private List<String> RightRightM;
    private List<String> LeftLeftM;
    private List<String> LeftRightD;
    private List<String> LeftRightU;
    private List<String> lineL;
    private List<String> lineR;
    private List<String> digitEight;

    private String Up = " ";
    private String Right = " ";
    private String Left = "|";
    private String LeftRight = "|";
    private String MRight = " ";
    private String LeftM = "|";
    private String RightLeftM = "|";

    public FormLCD(Byte width, Byte height) {
        this.width = width;
        this.height = height;
        this.numberForm = new HashMap<>();
        this.RightRightM = new ArrayList<>();
        this.LeftLeftM = new ArrayList<>();
        this.LeftRightD = new ArrayList<>();
        this.LeftRightU = new ArrayList<>();
        this.lineL = new ArrayList<>();
        this.lineR = new ArrayList<>();
        this.digitEight = new ArrayList<>();

        create();
    }

    private void create() {
        for (byte i = 0; i < this.width; i++) {
            this.Up += "_";
            this.MRight += "_";
            this.RightLeftM += "_";
            this.Right += " ";
            this.Left += " ";
            this.LeftRight += " ";
            this.LeftM += "_";
        }
        this.Up += " "; //  _
        this.MRight += "|"; // _|
        this.RightLeftM += "|"; // |_|
        this.Right += "|"; //   |
        this.LeftRight += "|"; // | |
        this.Left += " "; // |
        this.LeftM += " "; // |_

        if (this.height > 3) {
            byte add = (byte) (this.height / 2);
            this.LeftRightU.add(this.Up); // adaugam _
            this.lineL.add(this.Left); // adugam |
            this.lineR.add(this.Right); // adugam |
            this.digitEight.add(this.Up); // adugam _
            for (byte i = 0; i < add - 1; i++) {
                this.digitEight.add(this.LeftRight); //Adugam | |
                this.RightRightM.add(this.Right); // adaugam |
                this.LeftLeftM.add(this.Left); // adaugam |
                this.LeftRightD.add(this.LeftRight); // adaugam | |
                this.LeftRightU.add(this.LeftRight); // adaugam | |
                this.lineL.add(this.Left); // adugam |
                this.lineR.add(this.Right); // adugam |
            }
            this.LeftRightU.add(this.LeftRight); // adugam | |
            this.RightRightM.add(this.MRight); // adaugam _|
            this.LeftLeftM.add(this.LeftM); // adaugam |_
            this.LeftRightD.add(this.RightLeftM); // Adaugam |_|
        }

        this.numberForm.put((byte) 0, display((byte) 0));
        this.numberForm.put((byte) 1, display((byte) 1));
        this.numberForm.put((byte) 2, display((byte) 2));
        this.numberForm.put((byte) 3, display((byte) 3));
        this.numberForm.put((byte) 4, display((byte) 4));
        this.numberForm.put((byte) 5, display((byte) 5));
        this.numberForm.put((byte) 6, display((byte) 6));
        this.numberForm.put((byte) 7, display((byte) 7));
        this.numberForm.put((byte) 8, display((byte) 8));
        this.numberForm.put((byte) 9, display((byte) 9));
    }

    private String[] display(byte digit) {
        String[] digitForm;
        switch (digit) {
            case 0: {
                digitForm = new String[this.LeftRightU.size() + this.LeftRightD.size()];
                for (int i = 0; i < this.LeftRightU.size(); i++) {
                    digitForm[i] = this.LeftRightU.get(i);
                }
                for (int i = this.LeftRightU.size(), j = 0; j < this.LeftRightD.size(); i++, j++) {
                    digitForm[i] = this.LeftRightD.get(j);
                }
                return digitForm;
            }
            case 1: {
                digitForm = new String[1 + this.lineL.size() + this.lineR.size()];
                digitForm[0] = space();
                for (int i = 1; i <= this.lineR.size(); i++) {
                    digitForm[i] = this.lineR.get(i - 1);
                }
                for (int i = this.lineR.size() + 1, j = 0; j < this.lineR.size(); i++, j++) {
                    digitForm[i] = this.lineR.get(j);
                }
                return digitForm;
            }
            case 2: {
                digitForm = new String[1 + this.RightRightM.size() + this.LeftLeftM.size()];
                digitForm[0] = this.Up;
                for (int i = 1; i < this.RightRightM.size() + 1; i++) {
                    digitForm[i] = this.RightRightM.get(i - 1);
                }
                for (int i = this.RightRightM.size() + 1, j = 0; j < this.LeftLeftM.size(); i++, j++) {
                    digitForm[i] = this.LeftLeftM.get(j);
                }
                return digitForm;
            }
            case 3: {
                digitForm = new String[1 + (this.RightRightM.size() * 2)];
                digitForm[0] = this.Up;
                for (int i = 1; i < this.RightRightM.size() + 1; i++) {
                    digitForm[i] = this.RightRightM.get(i - 1);
                }
                for (int i = this.RightRightM.size() + 1, j = 0; j < this.RightRightM.size(); i++, j++) {
                    digitForm[i] = this.RightRightM.get(j);
                }
                return digitForm;
            }
            case 4: {
                digitForm = new String[1 + this.LeftRightD.size() + this.lineR.size()];
                digitForm[0] = space();
                for (int i = 1; i < this.LeftRightD.size() + 1; i++) {
                    digitForm[i] = this.LeftRightD.get(i - 1);
                }
                for (int i = this.LeftRightD.size() + 1, j = 0; j < this.lineR.size(); i++, j++) {
                    digitForm[i] = this.lineR.get(j);
                }
                return digitForm;
            }
            case 5: {
                digitForm = new String[1 + this.LeftLeftM.size() + this.RightRightM.size()];
                digitForm[0] = this.Up;
                for (int i = 1; i < this.LeftLeftM.size() + 1; i++) {
                    digitForm[i] = this.LeftLeftM.get(i - 1);
                }
                for (int i = this.RightRightM.size() + 1, j = 0; j < this.RightRightM.size(); i++, j++) {
                    digitForm[i] = this.RightRightM.get(j);
                }
                return digitForm;
            }
            case 6: {
                digitForm = new String[1 + this.LeftLeftM.size() + this.LeftRightD.size()];
                digitForm[0] = this.Up;
                for (int i = 1; i < this.LeftLeftM.size() + 1; i++) {
                    digitForm[i] = this.LeftLeftM.get(i - 1);
                }
                for (int i = this.LeftRightD.size() + 1, j = 0; j < this.LeftRightD.size(); i++, j++) {
                    digitForm[i] = this.LeftRightD.get(j);
                }
                return digitForm;
            }
            case 7: {
                digitForm = new String[1 + this.lineR.size() + this.lineR.size()];
                digitForm[0] = this.Up;
                for (int i = 1; i < this.lineR.size() + 1; i++) {
                    digitForm[i] = this.lineR.get(i - 1);
                }
                for (int i = this.lineR.size() + 1, j = 0; j < this.lineR.size(); i++, j++) {
                    digitForm[i] = this.lineR.get(j);
                }
                return digitForm;
            }
            case 8: {
                digitForm = new String[this.digitEight.size() * 2];
                for (int i = 0; i < this.digitEight.size(); i++) {
                    digitForm[i] = this.digitEight.get(i);
                }
                for (int i = this.digitEight.size(), j = 0; j < this.digitEight.size(); i++, j++) {
                    digitForm[i] = this.digitEight.get(j);
                }
                return digitForm;
            }
            case 9: {
                digitForm = new String[this.LeftRightU.size() + this.RightRightM.size()];
                for (int i = 0; i < this.LeftRightU.size(); i++) {
                    digitForm[i] = this.LeftRightU.get(i);
                }
                for (int i = this.LeftRightU.size() , j = 0; j < this.RightRightM.size(); i++, j++) {
                    digitForm[i] = this.RightRightM.get(j);
                }
                return  digitForm;
            }
            default: {
                System.out.println("Error");
                return null;
            }
        }
    }

    public void showNumber(List<Byte> digitsNumber) throws IOException {
        String[][] displayNumber = new String[this.height][digitsNumber.size()];
        StringBuilder sb = new StringBuilder();
        byte j = 0;
        for (byte digit : digitsNumber) {
            byte i = 0;
            if (this.numberForm.containsKey(digit)) {
                String[] formDigit = this.numberForm.get(digit);
                for (String s : formDigit) {
                    displayNumber[i][j] = s;
                    i++;
                }
            }
            j++;
        }
        for (int i = 0; i < this.height; i++) {
            for (int k = 0; k < digitsNumber.size(); k++) {
                System.out.print(displayNumber[i][k] + "   ");
                sb.append(displayNumber[i][k]).append("  ");
            }
            System.out.println();
            sb.append('\n');
            WriteOutput.writeLCD(sb.toString());
        }
    }

    private String space() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ".repeat(Math.max(0, this.height)));
        return sb.toString();
    }
}
