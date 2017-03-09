package leetcode_40_60;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Created by john on 2017/3/9.
 */
public class _59 {

    public static void main(String[] args) {
        _59 demo = new _59();
        demo.printMatrix(demo.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int i = 0, count = 1;
        while (count <= n*n) {
            int j = i;
            //the first line
            while (j < n - i) {
                matrix[i][j++] = count++;
            }
            //the first column
            j = i + 1;
            while (j < n - i) {
                matrix[j++][n - 1 - i] = count++;
            }
            //the second line
            j = n - i - 2;
            while (n - i - 1 > i && j >= i) {
                matrix[n - 1 - i][j--] = count++;
            }
            //the second column
            j = n - i - 2;
            while (n - i - 1 > i && j > i) {
                matrix[j--][i] = count++;
            }
            i++;
        }

        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
