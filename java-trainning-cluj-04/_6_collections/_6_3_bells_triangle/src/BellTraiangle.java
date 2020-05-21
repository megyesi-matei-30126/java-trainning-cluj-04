import java.util.Scanner;

public class BellTraiangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert lenght of triangle");
        int lenght = scanner.nextInt();
        scanner.nextLine();

        int[][] triangle = new int[lenght][lenght];

        triangle[0][0] = 1;

        for (int i = 1; i < lenght; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i - 1][i - 1];
                } else {
                    triangle[i][j] = triangle[i][j - 1] + triangle[i - 1][j - 1];
                }
            }
        }

        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                if (triangle[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(triangle[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
