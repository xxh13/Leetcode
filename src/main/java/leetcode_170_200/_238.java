package leetcode_170_200;

import org.junit.Test;

import java.util.stream.IntStream;

public class _238 {

	@Test
	public void test() {
		int[] nums = {1, 3};
		IntStream.of(productExceptSelf(nums)).forEach(System.out::println);
	}

	public int[] productExceptSelf(int[] nums) {

		int[] values1 = new int[nums.length];
		int[] values2 = new int[nums.length];

		int length = nums.length;

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				values1[i] = nums[i];
				values2[length - i - 1] = nums[length - i - 1];
			} else {
				values1[i] = nums[i] * values1[i - 1];
				values2[length - i - 1] = nums[length - i - 1] * values2[length - i];
			}
		}

		int[] output = new int[length];
		for (int i = 0; i < length; i++) {
			if (i == 0) {
				output[i] = values2[i + 1];
			} else if (i == length - 1) {
				output[i] = values1[i - 1];
			} else {
				output[i] = values1[i - 1] * values2[i + 1];
			}
		}

		return output;
	}
}
