package leetcode_170_200;

import org.junit.Test;

public class _209 {

	@Test
	public void test() {
		int[] nums = {9};
		int s = 7;
		System.out.println(solveNlogN(s, nums));
//		assert solveNlogN(s, nums) == 1;
	}

	public int minSubArrayLen(int s, int[] nums) {
		int min = nums.length;
		boolean canFind = false;

		for (int i = 0; i < nums.length; i++) {
			int sum = 0;

			int j = i;

			for (j = i; j < nums.length && sum < s; j++) {
				sum += nums[j];
			}

			if (sum >= s) {
				canFind = true;
				min = (j - i) < min ? (j - i) : min;
			}
		}

		return canFind ? min : 0;
	}


	private int solveNlogN(int s, int[] nums) {
		int[] sums = new int[nums.length + 1];

		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < sums.length; i++) {
			int len = binarySearch(i, sums.length - 1, sums[i] + s, sums);
			if (len == sums.length) break;
			min = min < len - i ? min : len - i;
		}

		return min == Integer.MAX_VALUE ? 0 : min;
	}

	private int binarySearch(int start, int end, int key, int[] array) {
		int i = start, j = end;

		while (i <= j) {
			int mid = (i + j) / 2;
			if (array[mid] > key) {
				j = mid - 1;
			} else if (array[mid] < key) {
				i = mid + 1;
			} else {
				return mid;
			}
		}

		return i;
	}


}
