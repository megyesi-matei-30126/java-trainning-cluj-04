public class FizzBuzz {
    public static void main(String[] args) {
        //Code_challenge_1
        //Stage 1
        System.out.println("STAGE 1: ");

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

        //Stage 2
        System.out.println("STAGE 2: ");

        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0){
                System.out.println("Rizz");
            } else if (i % 11 == 0){
                System.out.println("Jazz");
            } else{
                System.out.println(i);
            }
        }
    }
}
