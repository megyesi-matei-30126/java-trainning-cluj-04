public class MergeSort implements SortingStrategy {
    @Override
    public void sort(Integer[] list) {
        divide_impera(0, list.length - 1, list);
    }

    void combina(int inf, int med, int sup, Integer[] list) {
        int i = inf, j = med, k = inf, l;
        int[] b = new int[list.length];
        while ((i <= med) && (j <= sup)) {
            if (list[i] <= list[j]) {
                b[k] = list[i];
                i++;
            } else {
                b[k] = list[j];
                j++;
            }
            k++;
        }
        for (l = i; l <= med; l++) { /* au rămas elemente în stânga */
            b[k] = list[l];
            k++;
        }
        for (l = j; l <= sup; l++) { /* au rămas elemente în dreapta */
            b[k] = list[l];
            k++;
        }
        /* secvența între inf și sup este sortată */
        for (l = inf; l <= sup; l++) list[l] = b[l];
    }

    void divide_impera(int inf, int sup, Integer[] list) {
        int med;
        if (inf < sup) {
            med = (inf + sup) / 2;
            divide_impera(inf, med, list);
            divide_impera(med + 1, sup, list);
            combina(inf, med, sup, list);
        }
    }
}
