package leetcode_40_60;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
**/

public class _48 {

	public static void main(String[] args) {
		_48 demo = new _48();
		int nums[][] = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		demo.rotate(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	* (i, j) -> (j, n - i - 1)
	*/
	public void rotate(int[][] matrix) {
        int length = matrix.length;

		int i = 0;
        while (i < length / 2) {
        	for (int j = i; j < length - 1 - i; j++) {
        		int x1 = i, y1 = j, x2 = length - 1 - j, y2 = i;
        		int temp = matrix[i][j];
        		while (x2 != i || y2 != j) {
        			matrix[x1][y1] = matrix[x2][y2];
        			x1 = x2;
        			y1 = y2;
        			x2 = length - 1 - y2;
        			y2 = x1;
        		}
        		matrix[x1][y1] = temp;
        	}
        	i++;
        }
    }
}