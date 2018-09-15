package leetcode_300_400;


import org.junit.Test;

/**
 * dp solution
 */
public class _322 {

	@Test
	public void test() {
		int[] coins = {1};
		int amount = 0;
		assert coinChange(coins, amount) == -1;
	}

	public int coinChange(int[] coins, int amount) {
		if (amount == 0) return 0;
		int[] dp = new int[amount + 1];
		for (int i = 0; i <= amount; i++) {
			dp[i] = i;
			boolean canConstitute = false;
			for (int j = 0; j < coins.length; j++) {
				if (i == coins[j]) {
					canConstitute = true;
					dp[i] = 1;
					break;
				}
				if (i - coins[j] > 0 && dp[i - coins[j]] != -1) {
					canConstitute = true;
					dp[i] = dp[i] > 1 + dp[i - coins[j]] ? 1 + dp[i - coins[j]] : dp[i];
				}
			}
			dp[i] = canConstitute ? dp[i] : -1;
		}

		return dp[amount];
	}
}
