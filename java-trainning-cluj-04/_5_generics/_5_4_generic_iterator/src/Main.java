
public class Main {
    public static void main(String[] args) {
        // STAGE 1
        /*
        Integer[] list = new Integer[]{1, 2, 3};

        GenericIteratorImp<Integer> iterator = new GenericIteratorImp<>(list);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        //STAGE 2

        GenericListImp<Integer> listInteger = new GenericListImp<>();

        for (int i = 0; i < 5; i++) {
            listInteger.insert(i);
        }

        GenericIteratorImp<Integer> iteratorInteger = listInteger.iterator();

        while (iteratorInteger.hasNext()) {
            System.out.println(iteratorInteger.next());
        }

        GenericListImp<String> listString = new GenericListImp<>();
        listString.insert("Matei");
        listString.insert("Andrei");
        listString.insert("Cristina");
        listString.insert("Alex");
        listString.insert("Miruna");

        GenericIteratorImp<String> iteratorString = listString.iterator();

        while (iteratorString.hasNext()) {
            System.out.println(iteratorString.next());
        }
    }
}
