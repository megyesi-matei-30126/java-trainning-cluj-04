import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Leaders {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(1);
        integerList.add(10);
        integerList.add(4);
        integerList.add(21);
        integerList.add(8);

        Iterator<Integer> iterator = integerList.iterator();
        int indexIerator = 0;

        while (iterator.hasNext()) {
            Integer currentNumber = iterator.next();
            boolean leader = true;

            Iterator<Integer> iterator1 = integerList.listIterator(indexIerator);

            while (iterator1.hasNext()) {
                if (currentNumber < iterator1.next()) {
                    leader = false;
                    break;
                }
            }

            if (leader) {
                System.out.println(currentNumber);
            }

            indexIerator++;

        }
    }
}
