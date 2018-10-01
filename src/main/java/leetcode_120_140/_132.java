package leetcode_120_140;

import org.junit.Test;

public class _132 {

	@Test
	public void test() {
		String s = "abcba";
		System.out.println(minCut(s));;
	}

	public int minCut(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j + i < dp[0].length; j++) {
				if (i == 0) {
					dp[j][j + i] = 0;
				}
				else if (i == 1) {
					dp[j][j + i] = s.charAt(j) == s.charAt(j + i) ? 0 : 1;
				} else {
					if (dp[j + 1][j + i - 1] == 0 && s.charAt(j) == s.charAt(j + i)) {
						dp[j][j + i] = 0;
					} else {
						int min = i;
						for (int k = j; k < j + i; k++) {
							min = Math.min(dp[j][k] + dp[k + 1][j + i] + 1, min);
						}
						dp[j][j + i] = min;
					}
				}
			}
		}
		return dp[0][s.length() - 1];
	}
}
