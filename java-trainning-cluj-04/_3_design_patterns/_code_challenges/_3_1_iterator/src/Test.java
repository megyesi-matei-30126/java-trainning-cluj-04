public class Test {
    public static void main(String[] args) {
        ImpCollection collection = new ImpCollection();

        collection.add(1);
        collection.add(2);
        collection.add(5);

        ImpInterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ImpInterator iterator2 = collection.iterator();
        collection.remove(1);
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
