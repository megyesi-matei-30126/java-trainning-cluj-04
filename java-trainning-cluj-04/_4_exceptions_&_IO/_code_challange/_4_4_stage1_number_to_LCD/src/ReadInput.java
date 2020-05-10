import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInput {
    public static List<Byte> readIntput() throws IOException {
        List<Byte> digitsList = new ArrayList<>();
        String fileName = "Input.txt";

        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            digitsList.add(Byte.parseByte(scanner.nextLine()));
        }
        scanner.close();
        return digitsList;
    }
}
