import java.io.FileWriter;
import java.io.IOException;

public class WriteOutput {
    static void writeLCD(String digitForm) throws IOException {
        String fileName = "Output.txt";
        FileWriter fw = new FileWriter(fileName);
        fw.write(digitForm);

        fw.close();
    }
}
