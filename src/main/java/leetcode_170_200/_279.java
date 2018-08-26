package leetcode_170_200;


import org.junit.Test;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class _279 {
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			if (isSquareNumber(i)) {
				dp[i] = 1;
			} else {
				int min = i;
				int offset = 1;
				while (offset * offset <= i) {
					min = Math.min(min, 1 + dp[i - offset * offset]);
					offset++;
				}
				dp[i] = min;
			}
		}
		return dp[n];
	}

	private boolean isSquareNumber(int x) {
		return Math.pow((int) Math.sqrt(x), 2) == x;
	}


	@Test
	public void testIsSquareNumber() {
		assert isSquareNumber(9);
		assert !isSquareNumber(8);
	}

	@Test
	public void testNumSquares() {
		System.out.println(numSquares(100000));
	}
}
