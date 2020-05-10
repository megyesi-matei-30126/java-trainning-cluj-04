import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteOutput {
    public static void write(List<String> angaramList) throws IOException {
        String fileName = "Output.txt";
        FileWriter fw = new FileWriter(fileName);
        for (String word : angaramList) {
            fw.write(word);
            fw.write('\n');
        }
        fw.close();
    }
}
