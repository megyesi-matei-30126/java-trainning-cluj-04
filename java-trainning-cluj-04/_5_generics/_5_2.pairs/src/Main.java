public class Main {
    public static void main(String[] args) {
        Running r1 = new Running("RED", 41);
        Running r2 = new Running("RED", 39);
        Heels h1 = new Heels("GREEN", 30);

        Pair<Running> pair1 = new Pair<>(r1, r2);

        try {
            Check.check(pair1);
        } catch (ColorsDontMatchException | SizesDontMatchException e) {
            System.out.println("Error: " + e);
        }
    }
}
