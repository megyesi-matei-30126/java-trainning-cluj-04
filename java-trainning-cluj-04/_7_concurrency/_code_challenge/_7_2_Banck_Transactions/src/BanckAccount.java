public class BanckAccount {
    private String name;
    private int debit;

    public BanckAccount(String name, int debit) {
        this.name = name;
        this.debit = debit;
    }

    public synchronized void withdraw(double amount) {
        longDatabaseCall();
        if (this.debit >= amount) {
            this.debit -= amount;
            System.out.println("Withdraw: " + amount);
            System.out.println("Your new balance : " + this.debit);
        } else {
            System.out.println("Insufficient money!");
        }
    }

    public synchronized void deposit(double amount) throws InterruptedException {
        longDatabaseCall();
        this.debit += amount;
        System.out.println("Account " + this.name + " received " + amount);
        System.out.println("New balance : " + this.debit);
    }

    public void longDatabaseCall() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
