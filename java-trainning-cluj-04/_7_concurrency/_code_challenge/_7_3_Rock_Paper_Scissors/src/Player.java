import java.util.Random;

public class Player extends Thread {
    private String name;
    private String option;
    private String[] random = new String[]{"rock", "paper", "scissors"};

    public Player(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        this.option = randomOption();
        System.out.println(this.name + " choose " + this.option);
    }

    private String randomOption() {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        return this.random[randomNumber];
    }

    public String getOption() {
        return this.option;
    }
}
