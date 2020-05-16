import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(2);
        list.add(1);

        try {
            System.out.println(BinarySearch.search(list, 3));
        } catch (ArrayNotSortedExecption e) {
            System.out.println("Error: " + e);
        }
    }

}
