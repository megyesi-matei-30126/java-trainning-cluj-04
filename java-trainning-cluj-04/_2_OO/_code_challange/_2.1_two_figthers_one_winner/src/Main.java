public class Main {
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter();
        Fighter fighter2 = new Fighter("Andrei", 60, 110);
        BoxingMatch boxingMatch = new BoxingMatch(fighter1, fighter2);

        System.out.println(boxingMatch.fight());
    }
}
