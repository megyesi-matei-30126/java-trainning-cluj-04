public class Test {
    public static void main(String[] args) {
        MySetImp<Integer> mySetImp = new MySetImp<>();

        mySetImp.add(1);
        mySetImp.add(1);
        mySetImp.add(2);
        mySetImp.add(4);

        for (Object o : mySetImp.getMySet()) {
            System.out.println(o);
        }

        mySetImp.remove(1);

        mySetImp.set(1, 5);

        for (Object o : mySetImp.getMySet()) {
            System.out.println(o);
        }
    }
}
