public class Test {
    public static void main(String[] args) {
        CreateHashMap<Integer, String> cr = new CreateHashMap<>();

        cr.put(1, "Matei");
        cr.put(2, "Andrei");
        cr.put(3, "A");
        cr.put(4, "B");
        cr.put(5, "C");

        cr.remove(2);


        for (Node<Integer, String> node : cr.getNodes()) {
            System.out.println("Key: " + node.getKey());
            System.out.println("Value: " + node.getValue());
        }

        System.out.println(cr.get(4));
        System.out.println(cr.containsKey(6));
        System.out.println(cr.size());
    }
}
