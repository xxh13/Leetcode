package leetcode_150_170;

import java.util.Arrays;

public class _163 {

	public int maximumGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		int min = nums[0], max = nums[0];

		for (int ele : nums) {
			min = Math.min(ele, min);
			max = Math.max(ele, max);
		}

		int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));

		int[] bucketMin = new int[nums.length - 1];
		int[] bucketMax = new int[nums.length - 1];

		Arrays.fill(bucketMin, Integer.MAX_VALUE);
		Arrays.fill(bucketMax, Integer.MIN_VALUE);

		for (int ele : nums) {
			if (ele == min || ele == max) continue;
			int index = (ele - min) / gap;
			bucketMax[index] = Math.max(bucketMax[index], ele);
			bucketMin[index] = Math.min(bucketMin[index], ele);
		}

		int maxGap = 0;
		int pre = min;

		for (int i = 0; i < bucketMax.length; i++) {
			if (bucketMax[i] == Integer.MIN_VALUE && bucketMin[i] == Integer.MAX_VALUE) continue;
			maxGap = Math.max(maxGap, bucketMin[i] - pre);
			pre = bucketMax[i];
		}
		maxGap = Math.max(maxGap, max - pre);

		return maxGap;
	}
}
