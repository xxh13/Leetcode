package leetcode_170_200;

import org.junit.Test;

import java.util.stream.IntStream;

public class _200 {

    @Test
    public void test1() {
        char[][] grid = {
                {'1', '1', '0', '1', '1'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '0', '0', '1'},
                {'0', '1', '1', '1', '1'},
        };
        System.out.println(numIslands(grid));;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return  0;

        int[] parent = new int[grid.length * grid[0].length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i == 0 && j == 0) {
                        parent[0] = 0;
                    } else if (i == 0) {
                        parent[i * n + j] = parent[i * n + j - 1] == -1 ? i * n + j : parent[i * n + j - 1];
                    } else if (j == 0) {
                        parent[i * n + j] = parent[i * n + j - n] == -1 ? i * n + j : parent[i * n + j - n];
                    } else {
                        if (parent[i * n + j - n] != -1) {
                            //如果可以和上方相连， 尝试更新左边的连接体
                            if (parent[i * n + j - 1] != -1) {
                                int p_left = parent[i * n + j - 1];
                                int p_up = parent[i * n + j - n];
                                if (p_left > p_up) {
                                    updateParent(parent, p_left, p_up);
                                    parent[i * n + j] = p_up;
                                } else {
                                    updateParent(parent, p_up, p_left);
                                    parent[i * n + j] = p_left;
                                }
                            } else {
                                parent[i * n + j] =  parent[i * n + j - n];
                            }
                        } else if (parent[i * n + j - 1] != -1) {
                            parent[i * n + j] = parent[i * n + j - 1];
                        } else {
                            parent[i * n + j] = i * n + j;
                        }
                    }
                }
            }
        }
        return (int) IntStream.of(parent).filter(e -> e != -1).distinct().count();
    }

    private void updateParent(int[] parent, int p_old, int p_new) {
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == p_old) {
                parent[i] = p_new;
            }
        }
    }
}
