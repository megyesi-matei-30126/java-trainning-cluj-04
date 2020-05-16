public class GBP implements Money {
    private double value;

    public GBP() {
    }

    public GBP(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GBP{" +
                "value=" + value +
                '}';
    }
}
