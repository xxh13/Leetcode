package leetcode_170_200;

import org.junit.Test;

public class _221 {


    @Test
    public void test() {
        char[][] matrix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        assert maximalSquare(matrix) == 9;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0;
        int[][] square = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    square[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        square[i][j] = 1;
                        max = Math.max(max, 1);
                    } else if (i == 0 || j == 0) {
                        square[i][j] = 1;
                        max = Math.max(max, 1);
                    } else {
                        square[i][j] = Math.min(Math.min(square[i - 1][j], square[i - 1][j - 1]), square[i][j - 1]) + 1;
                        max = max > square[i][j] ? max : square[i][j];
                    }
                }
            }
        }

        return max * max;
    }
}
