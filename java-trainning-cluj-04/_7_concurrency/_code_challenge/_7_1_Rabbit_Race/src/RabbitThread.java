public class RabbitThread extends Thread {
    private int nr;

    public RabbitThread(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Rabbit " + this.nr + " running");
        }
    }
}
