import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormLCD {
    private byte width;
    private byte height;
    private List<String> finalForm;

    private List<String> RightRightM;
    private List<String> LeftLeftM;
    private List<String> LeftRightD;
    private List<String> LeftRightU;
    private List<String> lineL;
    private List<String> lineR;

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
        this.RightRightM = new ArrayList<>();
        this.LeftLeftM = new ArrayList<>();
        this.LeftRightD = new ArrayList<>();
        this.LeftRightU = new ArrayList<>();
        this.lineL = new ArrayList<>();
        this.lineR = new ArrayList<>();
        this.finalForm = new ArrayList<>();

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
            for (byte i = 0; i < add - 1; i++) {
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
    }

    public void displayNumberLCD(byte digit) {
        if (this.height > 3) {
            switch (digit) {
                case 0: {
                    this.finalForm.add("Number 0");
                    displayLeftRightU();
                    displayLeftRightD();
                    writeOutput();
                    break;
                }
                case 1: {
                    this.finalForm.add("Number 1");
                    displayLineR();
                    displayLineR();
                    writeOutput();
                    break;
                }
                case 2: {
                    this.finalForm.add("Number 2");
                    //System.out.println(this.Up);
                    this.finalForm.add(this.Up);
                    displayRightRightM();
                    displayLeftLeftM();
                    writeOutput();
                    break;
                }
                case 3: {
                    this.finalForm.add("Number 3");
                    //System.out.println(this.Up);
                    this.finalForm.add(this.Up);
                    displayRightRightM();
                    displayRightRightM();
                    writeOutput();
                    break;
                }
                case 4: {
                    this.finalForm.add("Number 4");
                    displayLeftRightD();
                    displayLineR();
                    writeOutput();
                    break;
                }
                case 5: {
                    this.finalForm.add("Number 5");
                    //System.out.println(this.Up);
                    this.finalForm.add(this.Up);
                    displayLeftLeftM();
                    displayRightRightM();
                    writeOutput();
                    break;
                }
                case 6: {
                    //System.out.println(this.Up);
                    this.finalForm.add("Number 6");
                    this.finalForm.add(this.Up);
                    displayLeftLeftM();
                    displayLeftRightD();
                    writeOutput();
                    break;
                }
                case 7: {
                    this.finalForm.add("Number 7");
                    //System.out.println(this.Up);
                    this.finalForm.add(this.Up);
                    displayLineR();
                    displayLineR();
                    writeOutput();
                    break;
                }
                case 8: {
                    this.finalForm.add("Number 8");
                    displayLeftRightU();
                    //System.out.println(this.Up);
                    this.finalForm.add(this.Up);
                    displayLeftRightD();
                    writeOutput();
                    break;
                }
                case 9: {
                    this.finalForm.add("Number 9");
                    displayLeftRightU();
                    //System.out.println(this.Up);
                    this.finalForm.add(this.Up);
                    displayLineR();
                    writeOutput();
                    break;
                }
                default: {
                    System.out.println("Error");
                }
            }
        } else {
            switch (digit) {
                case 0: {
                    System.out.println(this.Up);
                    System.out.println(this.LeftRight);
                    System.out.println(this.RightLeftM);
                    break;
                }
                case 1: {
                    System.out.println(this.Right);
                    System.out.println(this.Right);
                    break;
                }
                case 2: {
                    System.out.println(this.Up);
                    System.out.println(this.MRight);
                    System.out.println(this.LeftM);
                    break;
                }
                case 3: {
                    System.out.println(this.Up);
                    System.out.println(this.MRight);
                    System.out.println(this.MRight);
                    break;
                }
                case 4: {
                    System.out.println(this.RightLeftM);
                    System.out.println(this.Right);
                    break;
                }
                case 5: {
                    System.out.println(this.Up);
                    System.out.println(this.LeftM);
                    System.out.println(this.MRight);
                    break;
                }
                case 6: {
                    System.out.println(this.Up);
                    System.out.println(this.LeftM);
                    System.out.println(this.RightLeftM);
                    break;
                }
                case 7: {
                    System.out.println(this.Up);
                    System.out.println(this.Right);
                    System.out.println(this.Right);
                    break;
                }
                case 8: {
                    System.out.println(this.Up);
                    System.out.println(this.RightLeftM);
                    System.out.println(this.RightLeftM);
                    break;
                }
                case 9: {
                    System.out.println(this.Up);
                    System.out.println(this.RightLeftM);
                    System.out.println(this.Right);
                    break;
                }
                default: {
                    System.out.println("Error");
                }
            }
        }
    }

    private void writeOutput() {
        try {
            WriteOutput.writeLCD(this.finalForm);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private void displayRightRightM() {
        for (String form : this.RightRightM) {
            this.finalForm.add(form);
            //System.out.println(form);
        }
    }

    private void displayLeftLeftM() {
        for (String form : this.LeftLeftM) {
            this.finalForm.add(form);
           // System.out.println(form);
        }
    }

    private void displayLeftRightD() {
        for (String form : this.LeftRightD) {
            this.finalForm.add(form);
            //System.out.println(form);
        }
    }

    public void displayLeftRightU() {
        for (String form : this.LeftRightU) {
            this.finalForm.add(form);
            //System.out.println(form);
        }
    }

    private void displayLineR() {
        for (String form : this.lineR) {
            this.finalForm.add(form);
            //System.out.println(form);
        }
    }
}
