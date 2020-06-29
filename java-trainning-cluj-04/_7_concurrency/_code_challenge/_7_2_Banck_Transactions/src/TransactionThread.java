public class TransactionThread extends Thread {
    private String name;
    private BanckAccount from;
    private BanckAccount to;
    private int amount;

    public TransactionThread(String name, BanckAccount from, BanckAccount to, int amount) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public void run() {
        transfer(this.from, this.to, this.amount);
    }

    private  void transfer(BanckAccount from, BanckAccount to, int amount) {
        from.withdraw(amount);
        try {
            to.deposit(amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
