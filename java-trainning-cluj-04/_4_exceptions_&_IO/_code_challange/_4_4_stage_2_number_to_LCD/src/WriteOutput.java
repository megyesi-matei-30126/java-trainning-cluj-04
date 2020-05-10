import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteOutput {
    static void writeLCD(List<String> digitsLCD) throws IOException {
        String fileName = "Output.txt";
        FileWriter fw = new FileWriter(fileName);
        for (String digit : digitsLCD) {
            fw.write(digit);
            fw.write('\n');
        }
        fw.close();
    }
}
