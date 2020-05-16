import java.util.ArrayList;
import java.util.List;

public interface Money {
    double getValue();

    void setValue(double value);

    default double changeMoney(double rateChange, double valueChange, String currency1, String currency2) {
        List<String> currency = currencyValues();

        if (currency.indexOf(currency1) > currency.indexOf(currency2)) {
            return valueChange / rateChange;
        }
        return valueChange * rateChange;
    }

    default List<String> currencyValues() {
        List<String> currency = new ArrayList<>();
        currency.add("GBP");
        currency.add("Euro");
        currency.add("USD");
        currency.add("Lei");

        return currency;
    }
}
