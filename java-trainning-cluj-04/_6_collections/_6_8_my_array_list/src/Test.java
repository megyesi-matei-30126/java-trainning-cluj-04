import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        MyArrayListImp<Integer> myArray = new MyArrayListImp<>();

        myArray.add(1);
        myArray.add(2);
        myArray.add(3);

        myArray.remove(1);

        System.out.println(myArray.get(1));

        myArray.set(1, 4);

        for (Object i : myArray.getArrayList()) {
            System.out.println(i);
        }
    }
}
