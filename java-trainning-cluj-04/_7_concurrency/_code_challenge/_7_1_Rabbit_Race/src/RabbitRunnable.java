public class RabbitRunnable implements Runnable {
    private int nr;

    public RabbitRunnable(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Rabbit " + this.nr + " running");
        }
    }
}
