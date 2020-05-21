import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigZag {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(4);
        integerList.add(3);
        integerList.add(7);
        integerList.add(8);
        integerList.add(6);
        integerList.add(2);
        integerList.add(1);

        List<Integer> integerList2 = new ArrayList<>();
        integerList2.add(1);
        integerList2.add(4);
        integerList2.add(3);
        integerList2.add(2);

        rearrangeList(integerList);

        System.out.println("----------------------------");

        rearrangeList(integerList2);
    }

    public static void rearrangeList(List<Integer> integerList) {
        Iterator<Integer> integerIterator = integerList.iterator();
        int nextPos = 1;
        int currentPos = 0;

        while (integerIterator.hasNext() && nextPos <= integerList.size() - 1) {
            int currentNumber = integerIterator.next();
            if (currentPos % 2 == 0) {
                if (currentNumber > integerList.get(nextPos)) {
                    integerList.set(currentPos, integerList.get(nextPos));
                    integerList.set(nextPos, currentNumber);
                }
            } else {
                if (currentNumber < integerList.get(nextPos)) {
                    integerList.set(currentPos, integerList.get(nextPos));
                    integerList.set(nextPos, currentNumber);
                }
            }
            nextPos++;
            currentPos++;
        }

        for (Integer integer : integerList) {
            System.out.println(integer);
        }
    }
}
