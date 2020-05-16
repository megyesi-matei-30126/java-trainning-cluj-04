import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static <T extends Comparable<T>> int search(ArrayList<T> arrays, T valueSearch) throws ArrayNotSortedExecption{
        boolean done = false;
        boolean change = false;
        int left = 0;
        int right = arrays.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int resultOfCompare = arrays.get(middle).compareTo(valueSearch);

            if (resultOfCompare == 0) {
                return middle;
            }

            if (!done) {
                 if (resultOfCompare > 0) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            } else {
                if (resultOfCompare < 0) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }

            if (left >= right && !change) {
                left = 0;
                right = arrays.size() - 1;
                done = true;
                change = true;
            }
        }
        throw new ArrayNotSortedExecption("Array not sorted!");
    }
}
