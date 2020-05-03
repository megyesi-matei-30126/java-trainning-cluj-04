import java.util.Objects;

public class Apartament {
    private String name;
    private int monthlyRentCost;

    public Apartament(String name, int monthlyRentCost) {
        this.name = name;
        this.monthlyRentCost = monthlyRentCost;
    }

    public String getName() {
        return name;
    }

    public int getMonthlyRentCost() {
        return monthlyRentCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apartament that = (Apartament) o;
        return monthlyRentCost == that.monthlyRentCost &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, monthlyRentCost);
    }

    @Override
    public String toString() {
        return "Apratament{" +
                "name='" + name + '\'' +
                ", monthlyRentCost=" + monthlyRentCost +
                '}';
    }
}
