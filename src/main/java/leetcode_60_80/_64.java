package leetcode_60_80;

/**
 *
 * Created by john on 2017/3/10.
 */
public class _64 {

    public int minPathSum1(int[][] grid) {

        int row = grid.length;
        int column = grid[0].length;

        int[][] pathSum = new int[row][column];
        pathSum[0][0] = grid[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j > 0) {
                    pathSum[i][j] = pathSum[i][j - 1] + grid[i][j];
                }
                if (j == 0 && i > 0) {
                    pathSum[i][j] = pathSum[i - 1][j] + grid[i][j];
                }
                if (i > 0 && j > 0) {
                    pathSum[i][j] = Math.min(pathSum[i - 1][j], pathSum[i][j - 1]) + grid[i][j];
                }
            }
        }

        return pathSum[row - 1][column - 1];
    }


    //当向右和向下的权重一样时，需要考虑后续的情况
    public int minPathSum(int[][] grid) {
        int i = 0, j = 0, m = grid.length, n = grid[0].length;
        int sum = 0;

        while (i < m || j < n) {
            //reach the bottom, can just right
            sum += grid[i][j];
            if (i == m - 1) {
                for (int k = j + 1; k < n; k++)
                    sum += grid[i][k];
            }
            //reach the right side, can just down
            else if (j == n - 1) {
                for (int k = i + 1; k < m; k++)
                    sum += grid[k][j];
            } else {
                if (grid[i + 1][j] > grid[i][j + 1]) {
                    j ++;
                } else if (grid[i + 1][j] < grid[i][j + 1]) {
                    i ++;
                } else {
                    //相等情况下
                }
            }


        }

        return sum;
    }
}
