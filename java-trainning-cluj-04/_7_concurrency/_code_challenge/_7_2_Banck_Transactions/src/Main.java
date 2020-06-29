public class Main {
    public static void main(String[] args) {
        BanckAccount from = new BanckAccount("From", 1000);
        BanckAccount to = new BanckAccount("To", 9000);
        Thread thread = new TransactionThread("Transaction1", from, to, 100);
        thread.start();
    }
}
