import java.util.*;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        list.add("As");
        list.add("Bv");
        list.add("Masdf");

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Matei");
        map.put(2, "Andrei");
        map.put(3, "Cristina");

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        /*
        *   TEST EXERCISE1
         */
        System.out.println("----EXERCISE 1---");
        System.out.println(exercise_1(list));
        System.out.println("-------");
        /*
        * TEST EXERCISE2
         */
        System.out.println("----EXERCISE 2---");
        for (String s : exercise_2(list)) {
            System.out.println(s);
        }
        System.out.println("-------");

        /*
         * TEST EXERCISE3
         */
        System.out.println("----EXERCISE 3---");
        for (String s : exercise_3(list)) {
            System.out.println(s);
        }
        System.out.println("-------");

        /*
         * TEST EXERCISE4
         */
        System.out.println("----EXERCISE 4---");
        System.out.println(exercise_4(map));
        System.out.println("-------");

        /*
         * TEST EXERCISE5
         */
        System.out.println("----EXERCISE 5---");
        exercise_5(list1);
        Thread.sleep(1000);
        System.out.println("-------");
    }

    public static String exercise_1(List<String> list) {
        StringBuilder stringBuilder = list.stream()
                .filter((p) -> !p.isEmpty())
                .map((p) -> p.codePointAt(0))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);
        return stringBuilder.toString();
    }

    public static List<String> exercise_2(List<String> list) {
        return list.stream()
                .filter((s) -> s.length() % 2 == 0)
                .collect(Collectors.toList());
    }

    public static List<String> exercise_3(List<String> list) {
        return list.stream().filter((s) -> !s.isEmpty()).map(String::toUpperCase).collect(Collectors.toList());
    }

    public static String exercise_4(Map<Integer, String> map) {
        return map.entrySet().stream().map((s) -> s.getKey() + s.getValue()).collect(Collectors.joining());
    }

    public static void exercise_5(List<Integer> list) {
        new Thread(() -> {
            list.forEach(System.out::println);
        }).start();
    }
}
