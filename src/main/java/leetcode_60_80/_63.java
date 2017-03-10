package leetcode_60_80;

/**
 *
 * Created by john on 2017/3/10.
 */
public class _63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;

        int[][] paths = new int[row][column];

        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j > 0) {
                    paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i][j - 1];
                }
                if (j == 0 && i > 0) {
                    paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i - 1][j];
                }
                if (i > 0 && j > 0) {
                    paths[i][j] = obstacleGrid[i][j] == 1 ? 0 :
                            paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[row - 1][column - 1];
    }
}
