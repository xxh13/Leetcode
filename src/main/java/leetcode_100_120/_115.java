package leetcode_100_120;

import org.junit.Test;

public class _115 {

	private int num = 0;

	@Test
	public void test() {
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String t = "bcddceeeebecbc";

		System.out.println(numDistinct(s, t));
	}

	/**
	public int numDistinct(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		numDistinct(sArray, tArray, 0, 0);

		return num;
	}

	private void numDistinct(char[] aArray, char[] tArray, int aStart, int tIndex) {
		if (tIndex == tArray.length) {
			num++;
			return;
		}

		for (int i = aStart; i < aArray.length; i++) {
			if (aArray[i] == tArray[tIndex]) {
				tIndex++;
				numDistinct(aArray, tArray, i + 1, tIndex);
				tIndex--;
			}
		}
	}
	 **/

	public int numDistinct(String s, String t) {
		int n = s.length(), m = t.length();
		int[][] dp = new int[m+1][n+1];
		for(int j = 0; j < n; j++){
			dp[0][j] = 1;
		}
		for(int i = 1; i < m+1; i++){
			for(int j = 1; j < n+1; j++){
				if(s.charAt(j-1)==t.charAt(i-1)){
					dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
		return dp[m][n];
	}
}
