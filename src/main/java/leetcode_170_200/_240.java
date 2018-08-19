package leetcode_170_200;

import org.junit.Test;

public class _240 {


	@Test
	public void test() {
		int[][] data = {
				{5, 6, 10, 14},
				{6, 10, 13, 18},
				{10, 13, 18, 19},
		};

		assert searchMatrix(data, 14);

	}

	/**
	 *
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		return searchMatrix(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
	}

	private boolean searchMatrix(int[][] matrix, int x1, int y1, int x2, int y2, int target) {

		if (x1 == x2 && y1 == y2) {
			return matrix[x1][y1] == target;
		}

		Range horizontalRange = getHorizontalRange(matrix, y1, y2, x1, x2, target);
		if (horizontalRange.end == -1 && horizontalRange.start == -1) return true;

		Range verticalRange = getVerticalRange(matrix, x1, x2, y1, y2, target);
		if (verticalRange.end == -1 && verticalRange.start == -1) return true;


		//if the range do not change
		if (horizontalRange.start == x1 && horizontalRange.end == x2
				&& verticalRange.start == y1 && verticalRange.end == y2) return false;

		return searchMatrix(matrix, horizontalRange.start, verticalRange.start, horizontalRange.end, verticalRange.end, target);
	}

	private Range getHorizontalRange(int[][] matrix, int start, int end, int x1, int x2, int target) {
		Range range = new Range();
		range.start = x1;
		range.end = x2;

		int a1 = x1, a2 = x2, mid;
		while (a1 <= a2) {
			mid = (a1 + a2) / 2;
			if (matrix[mid][start] > target) {
				a2 = mid - 1;
			} else if (matrix[mid][start] < target) {
				a1 = mid + 1;
				if (a1 == x2) {
					range.end = matrix[a1][start] > target ? a1 - 1 : a1;
					break;
				}
				if (a1 > x2 || matrix[a1][start] > target) {
					range.end = a1 > x2 ? x2 : a1 - 1;
					break;
				}
			} else {
				range.start = -1;
				range.end = -1;
				return range;
			}
		}

		a1 = x1;
		a2 = x2;
		while (a1 <= a2) {
			mid = (a1 + a2) / 2;
			if (matrix[mid][end] > target) {
				a2 = mid - 1;
				if (a2 == x1) {
					range.start = matrix[a2][end] < target ? a2 + 1 : a2;
					break;
				}
				if (a2 < x1 || matrix[a2][end] < target) {
					range.start = a2 < x1 ? x1 : a2 + 1;
					break;
				}
			} else if (matrix[mid][end] < target) {
				a1 = mid + 1;
			} else {
				range.start = -1;
				range.end = -1;
				return range;
			}
		}

		return range;
	}

	private Range getVerticalRange(int[][] matrix, int start, int end, int y1, int y2, int target) {
		Range range = new Range();
		range.start = y1;
		range.end = y2;

		int a1 = y1, a2 = y2, mid;
		while (a1 <= a2) {
			mid = (a1 + a2) / 2;
			if (matrix[start][mid] > target) {
				a2 = mid - 1;
			} else if (matrix[start][mid] < target) {
				a1 = mid + 1;
				if (a1 == y2) {
					range.end = matrix[start][a1] > target ? a1 - 1 : a1;
					break;
				}
				if (a1 > y2 || matrix[start][a1] > target) {
					range.end = a1 > y2 ? y2 : a1 - 1;
					break;
				}
			} else {
				range.start = -1;
				range.end = -1;
				return range;
			}
		}

		a1 = y1;
		a2 = y2;
		while (a1 <= a2) {
			mid = (a1 + a2) / 2;
			if (matrix[end][mid] > target) {
				a2 = mid - 1;
				if (a2 == y1) {
					range.start = matrix[end][a2] < target ? a2 + 1 : a2;
					break;
				}
				if (a2 < y1 || matrix[end][a2] < target) {
					range.start = a2 < y1 ? y1 : a2 + 1;
					break;
				}
			} else if (matrix[end][mid] < target) {
				a1 = mid + 1;
			} else {
				range.start = -1;
				range.end = -1;
				return range;
			}
		}

		return range;
	}

	/**
	 * [start, end]
	 */
	private class Range {
		int start;
		int end;
	}

}
