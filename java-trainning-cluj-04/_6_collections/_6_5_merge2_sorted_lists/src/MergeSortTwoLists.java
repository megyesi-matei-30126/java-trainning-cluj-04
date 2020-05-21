import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortTwoLists {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(1);
        list1.add(5);
        list1.add(6);
        list2.add(2);
        list2.add(3);
        list2.add(4);

        List<Integer> newList = combineLists(list1, list2);
        sort(newList, 0, newList.size() - 1);

        for (Integer i : newList) {
            System.out.println(i);
        }
    }

    public static List<Integer> combineLists(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }

    public static void sort(List<Integer> list, int left, int right) {
        if (right <= left) return;

        int mid = (left+right)/2;
        sort(list, left, mid);
        sort(list, mid+1, right);
        mergeSort(list, left, mid, right);
    }

    public static void mergeSort(List<Integer> list, int left, int middle, int right) {
        int[] leftElement = new int[middle - left + 1];
        int[] rightElement = new int[right - middle];

        for (int i = 0; i < leftElement.length; i++)
            leftElement[i] = list.get(left + i);

        for (int i = 0; i < rightElement.length; i++)
            rightElement[i] = list.get(middle + i + 1);

        int l = 0;
        int r = 0;

        for (int i = left; i < right + 1; i++) {
            if (l < leftElement.length && r < rightElement.length) {
                if (leftElement[l] < rightElement[r]) {
                    list.set(i, leftElement[l]);
                    l++;
                } else {
                    list.set(i, rightElement[r]);
                    r++;
                }
            } else if (l < leftElement.length) {
                list.set(i, leftElement[l]);
                l++;
            } else if (r < rightElement.length) {
                list.set(i, rightElement[r]);
                r++;
            }
        }
    }
}
