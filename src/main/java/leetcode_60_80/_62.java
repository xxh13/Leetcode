package leetcode_60_80;

/**
 *
 * Created by john on 2017/3/10.
 */
public class _62 {

    public static void main(String[] args) {
        _62 demo = new _62();
        System.out.println(demo.uniquePaths(3,7));
    }

    /**
     *
     * @param m : the row of the array
     * @param n : the column of the array
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] paths = new int[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    paths[i][j] = 1;
                }
                if (j == 0) {
                    paths[i][j] = 1;
                }
                if (i != 0 && j != 0) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }
}
