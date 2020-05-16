public class Main {
    public static void main(String[] args) {
        String rootValue = "a";

        GenericList<String> list = new GenericList<>(rootValue);
        for (int i = 1; i < 10; i++) {
            list.insert(String.valueOf(Character.valueOf((char)(rootValue.charAt(0) + i))));
        }
        list.println();

        GenericList<Integer> listInteger = new GenericList<>(0);
        for (int i = 1; i < 10; i++) {
            listInteger.insert(i);
        }
        listInteger.println();
    }
}
