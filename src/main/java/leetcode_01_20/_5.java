package leetcode_01_20;

import org.junit.Test;

public class _5 {

	@Test
	public void test() {
		String s = "12212321";
		System.out.println(longestPalindrome(s));
	}

	public String longestPalindrome(String s) {
		int sLength = s.length();
		char[] chars = new char[sLength * 2 + 1];

		for (int i = 0; i < chars.length; i++) {
			chars[i] = i % 2 == 0 ? '#' : s.charAt(i / 2);
		}

		int[] dp = new int[chars.length];

		int max = 0, id = 0;
		for (int i = 0; i < dp.length; i++) {
			dp[i] = i <= max ? 1 : Math.min(dp[2 * id - i], max - i);

			while (i - dp[i] >= 0 && i + dp[i] <= dp.length - 1 && chars[i - dp[i]] == chars[i + dp[i]]) {
				dp[i]++;
			}

			if (dp[i] + i > max) {
				max = dp[i] + i;
				id = i;
			}
		}

		int index = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > dp[index]) {
				index = i;
			}
		}

		return new String(chars, index + 1 - dp[index], dp[index] * 2 - 1).replace("#", "");
	}
}
