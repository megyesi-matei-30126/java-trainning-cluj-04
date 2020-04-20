import java.util.ArrayList;
import java.util.List;

public class FooBarQix {
    static int[] numberToDivide = {3, 5, 7};
    static String[] wrodToReplace = {"Foo", "Bar", "Qix"};
    static List<Integer> formNumber = new ArrayList<>();
    static int zero = 0;

    public static void main(String[] args) {
        // write your code here
        //Stage 1
        /*
        for (int i = 1; i <= 100; i++) {
            System.out.println(compute(i));
            formNumber.removeAll(formNumber);
        }*/

        //Stage 2
        for (int i = 1; i <= 150; i++) {
            System.out.println(compute2(i));
            formNumber.removeAll(formNumber);
        }
        //System.out.println(compute2(10101));
    }

    public static List<Integer> getFormNumberormNumber(int number) {
        while (number != 0) {
            formNumber.add(number % 10);
            number /= 10;
        }

        return formNumber;
    }

    public static String compute(int number) {
        String result = "";
        int size = getFormNumberormNumber(number).size() - 1;

        for (int i = 0; i < numberToDivide.length; i++) {
            if (number % numberToDivide[i] == 0) {
                result += wrodToReplace[i];
            }
        }

        for (int i = size; i >= 0; i--) {
            for (int j = 0; j < numberToDivide.length; j++) {
                if (getFormNumberormNumber(number).get(i).equals(numberToDivide[j])) {
                    result += wrodToReplace[j];
                }
            }
        }

        if (result.equals("")) {
            result += Integer.toString(number);
        }

        return result;
    }

    public static String compute2(int number) {
        int size = getFormNumberormNumber(number).size() - 1;
        String result = "";

        for (int i = 0; i < numberToDivide.length; i++) {
            if (number % numberToDivide[i] == 0) {
                result += wrodToReplace[i];
            }
        }

        for (int i = size; i >= 0; i--) {
            for (int j = 0; j < numberToDivide.length; j++) {
                if (getFormNumberormNumber(number).get(i).equals(numberToDivide[j])) {
                    result += wrodToReplace[j];
                }
            }
            if (getFormNumberormNumber(number).get(i).equals(zero)) {
                result += "*";
            }
        }

        if (result.equals("") || result.equals("*")) {
            result = "";
            for (int i = size; i >= 0; i--) {
                if (getFormNumberormNumber(number).get(i) == zero) {
                    result += "*";
                } else {
                    result += Integer.toString(getFormNumberormNumber(number).get(i));
                }
            }
        }

        return result;
    }
}
