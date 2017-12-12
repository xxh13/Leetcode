package leetcode_80_100;


import java.util.Stack;

public class _85 {

    public static void main(String[] args) {
        _85 demo = new _85();
        char[][] matrix = {
                {'0'}
        };
        int area = demo.maximalRectangle(matrix);
        System.out.println(area);
    }

    private int[][] changeRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            int maxOne = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    maxOne++;
                    result[i][j] = maxOne;
                } else {
                    maxOne = 0;
                    result[i][j] = 0;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        return result;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (n == 0) return 0;

        int[][] matrixOne = changeRectangle(matrix);

        int max = 0;

        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            int j = 0;
            while (j < n || !stack.empty()) {
                if (stack.empty() || (j < n && matrixOne[stack.peek()][i] <= matrixOne[j][i])) {
                    stack.push(j);
                    j++;
                } else {
                    int tp = stack.pop();
                    int area = matrixOne[tp][i] * (stack.empty() ? j : j - stack.peek() - 1);
                    max = max > area ? max : area;
                }
            }
        }

        return max;
    }
}
