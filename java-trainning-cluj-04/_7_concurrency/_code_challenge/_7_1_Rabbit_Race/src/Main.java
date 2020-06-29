public class Main {
    public static int v = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            Thread thread;
            if (i % 2 == 0) {
                thread = new RabbitThread(i);
               thread.start();
            } else {
                thread = new Thread(new RabbitRunnable(i));
                thread.start();
            }
            thread.join();
        }
    }
}
