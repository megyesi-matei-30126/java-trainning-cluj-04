public class BubbleSort implements SortingStrategy {

    @Override
    public void sort(Integer[] list) {
        int i;
        int j = 0;
        boolean gata;

        do {
            gata = false;
            j++;
            for (i = 0; i < list.length - j; i++) {
                if (list[i] > list[i + 1]) {
                    gata = true;
                    int x = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = x;
                }
            }

        } while (gata);
    }
}
