package graph;

/**
 *
 * Created by XXH on 2016/9/13.
 */
public class Blocks {

    public static void main(String[] args) {
        int [][] grid = {
                {0, 0, 1, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 1, 0}
        };
        int num = getBlocks(grid);
        System.out.println(num);
    }

    public static int getBlocks(int grid[][]) {
        int num = 0;

        int row = grid.length;
        int col = grid[0].length;
        int reach[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (grid[i][j] == 1 && reach[i][j] == 0) {
                    reach(grid, i, j, reach);
                    num ++;
                }
            }
        }
        return num;
    }


    public static void reach(int grid[][], int i, int j, int reach[][]) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || grid[i][j] == 0 || reach[i][j] == 1) return;

        reach[i][j] = 1;

        reach(grid, i - 1, j, reach);
        reach(grid, i, j -1, reach);
        reach(grid, i + 1, j, reach);
        reach(grid, i, j + 1, reach);
    }


}
