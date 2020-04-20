import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PiarOf2 {
    public static void main(String[] args) {
        List<Integer> listOfNumber = new ArrayList<>();
        boolean optionContinue = true;
        int numberOfPairs = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("List must have minim 3 numbers!");
        while (optionContinue) {
            byte option;
            System.out.println("1 - add number!\n2 - view list of number\n3 - exit and view results!");
            System.out.println("Choose a option: ");
            option = scanner.nextByte();

            switch (option) {
                case 1: {
                    System.out.println("Insert number in list of number: ");
                    int numberInsert = scanner.nextInt();
                    listOfNumber.add(numberInsert);
                    System.out.println("Number: " + numberInsert + " add with success!");
                    break;
                }
                case 2: {
                    System.out.println(listOfNumber.toString());
                    break;
                }
                case 3: {
                    System.out.println("Good Bye!");
                    optionContinue = false;
                    break;
                }
                default: {
                    System.out.println("Wrong choose!");
                    break;
                }
            }
        }

        for (int i = 0; i < listOfNumber.size(); i++) {
            for (int k = 0; k < listOfNumber.size(); k++) {
                if (i == k) {
                    continue;
                }
                if (listOfNumber.get(i) + listOfNumber.get(k) == 0) {
                    numberOfPairs++;
                    listOfNumber.remove(i);
                    listOfNumber.remove(k);
                    break;
                }
            }
        }
        System.out.println("Number of pairs: " + numberOfPairs);
    }
}
