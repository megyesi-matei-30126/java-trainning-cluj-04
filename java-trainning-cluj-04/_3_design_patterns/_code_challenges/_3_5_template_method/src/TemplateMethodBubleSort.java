public abstract class TemplateMethodBubleSort {
    public void sort(Integer[] list) {
        int i;
        int j = 0;
        for (i = 0; i < list.length - 1; i++) {
            j++;
            for (int k = 0; k < list.length - j; k++) {
                if (numbersInCorrectOrder(list[k], list[k + 1])) {
                    int aux = list[k];
                    list[k] = list[k + 1];
                    list[k + 1] = aux;
                }
            }
        }
    }

    abstract boolean numbersInCorrectOrder(Integer i1, Integer i2);
}
