import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Angaram {
    static void readListOfWords(List<String> wordsList) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("SmallList"));
        while (scanner.hasNext()) {
            wordsList.add(scanner.next());
        }
        scanner.close();
    }

    static void findArangam(List<String> angaramList, String word1, String word2) {
        if (!word1.equals(word2)) {
            if (word1.length() == word2.length()) {
                char[] charsWord1 = new char[word1.length()];
                char[] charsWord2 = new char[word1.length()];

                for (int i = 0; i < charsWord1.length; i++) {
                    charsWord1[i] = word1.charAt(i);
                    charsWord2[i] = word2.charAt(i);
                }

                Arrays.sort(charsWord1);
                Arrays.sort(charsWord2);

                if (checkCharacter(charsWord1, charsWord2)) {
                    if (!angaramList.contains(word1)) {
                        angaramList.add(word1);
                    }
                    if (!angaramList.contains(word2)) {
                        angaramList.add(word2);
                    }
                }
            }
        }
    }

    static boolean checkCharacter(char[] word1, char[] word2) {
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] != word2[i]) {
                return false;
            }
        }
        return true;
    }
}
