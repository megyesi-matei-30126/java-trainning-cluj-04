
public class ExchangeDesk<T extends Money, V extends Money> {
    private V typeofMoneyChanged;

    public ExchangeDesk() {
    }

    public V convert(T change, Class<V> moneyChanged, double rate) {
        double currentValue = change.getValue();

        try {
            this.typeofMoneyChanged = moneyChanged.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error: " + e);
        }

        double changedMoney = this.typeofMoneyChanged.changeMoney(rate, currentValue, change.getClass().getName(), this.typeofMoneyChanged.getClass().getName());
        this.typeofMoneyChanged.setValue(changedMoney);

        return this.typeofMoneyChanged;
    }
}
