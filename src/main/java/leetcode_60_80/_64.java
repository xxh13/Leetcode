package leetcode_60_80;

/**
 *
 * Created by john on 2017/3/10.
 */
public class _64 {

    public static void main(String[] args) {
        _64 demo = new _64();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(demo.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        return minPathSumSub(grid, 0, 0, 0);
    }

    /**
     * dp
     * @param grid
     * @return
     */
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
    //time limited
    private int minPathSumSub(int[][] grid, int i, int j, int sum) {
        //当到达终点时
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return sum + grid[i][j];
        }

        //当到达右边界时
        else if (j == grid[0].length - 1) {
            return minPathSumSub(grid, i + 1, j, sum + grid[i][j]);
        }

        //当到达下边界时
        else if (i == grid.length - 1) {
            return minPathSumSub(grid, i, j + 1, sum + grid[i][j]);
        }

        else {
            return Math.min(
                    minPathSumSub(grid, i + 1, j, sum + grid[i][j]),
                    minPathSumSub(grid, i, j + 1, sum + grid[i][j]));
        }

    }
}
