
public class Lei implements Money {
    private double value;

    public Lei() {
    }

    public Lei(double value) {
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
        return "Lei{" +
                "value=" + value +
                '}';
    }
}
