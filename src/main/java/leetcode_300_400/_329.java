package leetcode_300_400;

import org.junit.Test;

public class _329 {

	@Test
	public void test() {
		int[][] matrix = {
				{0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
				{19,18,17,16,15,14,13,12,11,10},
				{20,21,22,23,24,25,26,27,28,29},
				{39,38,37,36,35,34,33,32,31,30},
				{40,41,42,43,44,45,46,47,48,49},
				{59,58,57,56,55,54,53,52,51,50},
				{60,61,62,63,64,65,66,67,68,69},
				{79,78,77,76,75,74,73,72,71,70},
				{80,81,82,83,84,85,86,87,88,89},
				{99,98,97,96,95,94,93,92,91,90},
				{100,101,102,103,104,105,106,107,108,109},
				{119,118,117,116,115,114,113,112,111,110},
				{120,121,122,123,124,125,126,127,128,129},
				{139,138,137,136,135,134,133,132,131,130},
				{0,0,0,0,0,0,0,0,0,0}
		};

		System.out.println(longestIncreasingPath(matrix));
//		assert longestIncreasingPath(matrix) == 4;
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int max = 0;
		int[][] cached = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int path = longestIncreasingPath(matrix, i, j, true, matrix[i][j], cached);
				max = path > max ? path : max;
			}
		}

		return max;
	}

	private int longestIncreasingPath(int[][] matrix, int i, int j, boolean start, int pre, int[][] cached) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;

		if (!start && matrix[i][j] <= pre) {
			return 0;
		}

		if (cached[i][j] != 0) {
			return cached[i][j];
		}

		//right
		int right = longestIncreasingPath(matrix, i + 1, j, false, matrix[i][j], cached);

		//down
		int down = longestIncreasingPath(matrix, i, j + 1, false, matrix[i][j], cached);

		//left
		int left = longestIncreasingPath(matrix, i - 1, j, false, matrix[i][j], cached);

		//up
		int up = longestIncreasingPath(matrix, i, j - 1, false, matrix[i][j], cached);

		int longest = Math.max(Math.max(right, left), Math.max(up, down));

		cached[i][j] = longest + 1;

		return longest + 1;
	}
}
