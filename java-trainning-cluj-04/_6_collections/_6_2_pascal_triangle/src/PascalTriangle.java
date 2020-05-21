public class PascalTriangle {
    public static void main(String[] args) {
        int lenght = 5;
        int[][] triangle = new int[5][5];

        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    triangle[i][j] = 1; // daca i = 0 e prima coloana care tot timpul e 1, iar cand j = i tot timpul e 1
                } else {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
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
