import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static String readFile() throws IOException {
        String fileName = "Text";
        StringBuilder secretMessage = new StringBuilder();

        FileReader fr = new FileReader(fileName);
        BufferedReader bf = new BufferedReader(fr);
        int characterRead = 0;

        while ((characterRead = bf.read()) != -1) {
            char charcterConvertToASCII = (char) characterRead;
            if (Character.isUpperCase(charcterConvertToASCII)) {
                if (charcterConvertToASCII == 'X') {
                    secretMessage.append(" ");
                } else {
                    secretMessage.append(charcterConvertToASCII);
                }
            }
        }
        fr.close();
        bf.close();
        return secretMessage.toString();
    }
}
