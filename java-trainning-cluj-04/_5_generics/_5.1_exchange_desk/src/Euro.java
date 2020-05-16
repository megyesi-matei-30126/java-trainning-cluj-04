public class Euro implements Money {
    private double value;

    public Euro() {

    }

    public Euro(double value) {
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
        return "Euro{" +
                "value=" + value +
                '}';
    }
}
