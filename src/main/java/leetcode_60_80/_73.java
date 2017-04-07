package leetcode_60_80;

public class _73 {

    public static void main(String[] args) {
        _73 demo = new _73();
        int[][] matrix = {
            {1},
            {0}
        };

        demo.printArray(matrix);
        demo.setZeros(matrix);
        demo.printArray(matrix);
    }

    public void printArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param : matrix
     * @return :
     */
    public void setZeros(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return;
        int m = matrix[0].length;
        int sign = 1;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) sign = 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        //set related line to zero
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if (sign == 0) matrix[i][0] = 0;
        }
    }
}
