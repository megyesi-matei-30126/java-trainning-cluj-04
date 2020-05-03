import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 4, 5, 2, 3, 6, 9, 8, 7};
        Integer[] copy010Arr = Arrays.copyOf(arr, arr.length);
        Integer[] copy020Arr = Arrays.copyOf(arr, arr.length);

        DescBubleSort desc = new DescBubleSort();
        desc.sort(copy010Arr);
        AscBubleSort asc = new AscBubleSort();
        asc.sort(copy020Arr);

        display(copy010Arr);
        display(copy020Arr);
    }

    public static void display(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
