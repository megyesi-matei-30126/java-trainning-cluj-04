public class Check {
    public static<T extends Shoe> void check(Pair<T> pair) throws ColorsDontMatchException, SizesDontMatchException {
        if (!pair.getFirst().getColor().equals(pair.getSecond().getColor())) {
            throw new ColorsDontMatchException("Color don't match");
        }
        if (pair.getFirst().getSize() != pair.getSecond().getSize()) {
            throw new SizesDontMatchException("Size don't match!");
        }
    }
}
