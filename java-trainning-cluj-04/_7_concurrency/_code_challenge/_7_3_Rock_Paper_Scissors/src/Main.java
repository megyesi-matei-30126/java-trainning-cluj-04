public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        player1.start();
        player2.start();
        player2.join();
        Thread.sleep(1000);
        winner(player1.getOption(), player2.getOption());
    }

    public static void winner(String option1, String option2) {
        if (option1.equals(option2)) {
            System.out.println("Draw");
        } else if (option1.equals("rock")) {
            if (option2.equals("paper")) {
                System.out.println("Player2 win!");
            } else {
                System.out.println("Player1 win!");
            }
        } else if (option1.equals("paper")) {
            if (option2.equals("rock")) {
                System.out.println("Player1 win!");
            } else {
                System.out.println("Player2 win!");
            }
        } else if (option1.equals("scissors")) {
            if (option2.equals("rock")) {
                System.out.println("Player 2 win!");
            } else {
                System.out.println("Player 1 win!");
            }
        }
    }
}
