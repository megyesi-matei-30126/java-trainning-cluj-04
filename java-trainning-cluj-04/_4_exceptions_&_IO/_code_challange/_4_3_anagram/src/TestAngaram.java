import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestAngaram {
    public static void main(String[] args) {
        List<String> wordsList = new ArrayList<>();
        List<String> angaramList = new ArrayList<>();
        try {
            Angaram.readListOfWords(wordsList);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e);
        }

        for (String word : wordsList) {
            for (String word2 : wordsList) {
                Angaram.findArangam(angaramList, word, word2);
            }
        }

        try {
            WriteOutput.write(angaramList);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
