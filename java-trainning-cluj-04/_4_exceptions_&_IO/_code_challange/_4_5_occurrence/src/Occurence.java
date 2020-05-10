import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Occurence {
    HashMap<String, Integer> wordsAndValues;
    List<Integer> countWords;
    List<String> words;

    public Occurence() {
        this.wordsAndValues = new HashMap<>();
        this.countWords = new ArrayList<>();
        this.words = new ArrayList<>();
    }

    public void readInput() throws FileNotFoundException {
        String fileName = "Input.txt";

        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            String word = scanner.next();
            int count = 0;

            Scanner scanner1 = new Scanner(new File(fileName));
            while (scanner1.hasNext()) {
                String word1 = scanner1.next();
                if (word.equals(word1)) {
                    count++;
                }
            }
            this.wordsAndValues.put(word, count);
        }
        scanner.close();
    }

    public void displayFist10Words() {
        sortWordsAndValues();
        for (int i = 0; i < this.words.size(); i++) {
            System.out.println(this.words.get(i) + " : " + this.countWords.get(i));
        }
    }

    private void sortWordsAndValues() {
        this.countWords.addAll(this.wordsAndValues.values());
        this.words.addAll(this.wordsAndValues.keySet());
        for (int i = 0; i < this.countWords.size(); i++) {
            for (int j = 0; j < this.countWords.size(); j++) {
                if (i != j) {
                    if (i < j) {
                        int aux = this.countWords.get(i); String auxS = this.words.get(i);
                        this.countWords.set(i, this.countWords.get(j)); this.words.set(i, this.words.get(j));
                        this.countWords.set(j, aux); this.words.set(j, auxS);
                    }
                }
            }
        }
        while (this.words.size() != 10){
            this.words.remove(this.words.size() - 1);
            this.countWords.remove(this.countWords.size() - 1);
        }
    }

    public static void main(String[] args) {
        Occurence oc = new Occurence();
        try {
            oc.readInput();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        oc.displayFist10Words();
    }
}
