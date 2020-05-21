public class MatrixSpiral {
    public static void main(String[] args) {
        int[][] squareMatrix = {{1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};

        int i = 0;
        int j = 0;
        int lines = 4;
        int colums = 4;

        while (i < lines && j < colums) {

            for (int k = j; k < colums; k++) {
                System.out.print(squareMatrix[i][k] + " "); // afisam prima linie
            }
            i++;

            for (int k = i; k < lines; k++) {
                System.out.print(squareMatrix[k][colums - 1] + " "); // afisam ultima coloana
            }
            colums--;

            for (int k = colums - 1; k >= j; k--) {
                System.out.print(squareMatrix[lines - 1][k] + " ");
            }
            lines--;

            for (int k = lines - 1; k >= i; k--) {
                System.out.print(squareMatrix[k][j] + " ");
            }
            j++;
        }
    }
}
