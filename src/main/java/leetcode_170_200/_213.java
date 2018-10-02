package leetcode_170_200;

import org.junit.Test;

import java.util.stream.IntStream;

public class _213 {

	@Test
	public void test() {
		int[] nums = {2};
		System.out.println(rob(nums));
	}

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		}

		int[] dp1 = new int[nums.length - 1];
		int[] dp2 = new int[nums.length - 1];

		for (int i = 0; i < dp1.length; i++) {
			if (i == 0) {
				dp1[i] = nums[i];
				dp2[i] = nums[i + 1];
			} else if (i == 1) {
				dp1[i] = Math.max(nums[0], nums[1]);
				dp2[i] = Math.max(nums[1], nums[2]);
			} else {
				dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
				dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i + 1]);
			}
		}

		int max1 = IntStream.of(dp1).max().getAsInt();
		int max2 = IntStream.of(dp2).max().getAsInt();

		return Math.max(max1, max2);
	}
}
