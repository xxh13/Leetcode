package leetcode_170_200;

import org.junit.Test;

import java.util.stream.IntStream;

public class _300 {

	@Test
	public void test() {
		int[] nums = {10,9,2,5,3,7,101,18};

		assert 4 == lengthOfLIS(nums);
	}

	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;

		int[] LIS = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				LIS[i] = 1;
			} else {
				int max = 1;
				for (int j = 0; j <= i - 1; j++) {
					if (nums[i] > nums[j]) {
						LIS[i] = Math.max(max, LIS[j] + 1);
						max = LIS[i];
					} else {
						LIS[i] = Math.max(max, 1);
					}
				}
			}
		}

		return IntStream.of(LIS).max().getAsInt();
	}
}
