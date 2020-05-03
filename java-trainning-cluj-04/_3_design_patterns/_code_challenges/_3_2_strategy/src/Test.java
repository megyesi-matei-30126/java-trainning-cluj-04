import java.util.Arrays;

public class Test {
    public void testStrategy(SortingStrategy sortingStrategy, Integer[] list){
        sortingStrategy.sort(list);
    }
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[]  copy010Arr = Arrays.copyOf(arr, arr.length);
        Integer[]  copy020Arr = Arrays.copyOf(arr, arr.length);
        Test test = new Test();

        System.out.println("Sorting with bubbleSort alogorithm");
        test.testStrategy(new BubbleSort(), copy010Arr);
        for (int i : copy010Arr){
            System.out.println(i);
        }

        System.out.println("Sorting with mergeSort alogorithm");
        test.testStrategy(new BubbleSort(), copy020Arr);
        for (int i : copy010Arr){
            System.out.println(i);
        }
    }
}
