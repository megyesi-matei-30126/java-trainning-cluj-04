public class USD implements Money {
    private double value;

    public USD() {
    }

   public USD(double value) {
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
        return "USD{" +
                "value=" + value +
                '}';
    }
}
