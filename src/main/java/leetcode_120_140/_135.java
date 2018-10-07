package leetcode_120_140;

import org.junit.Test;

import java.util.Arrays;

public class _135 {

	@Test
	public void test() {
		int[] ratings = {1,0,2};
		System.out.println(candy(ratings));
	}

	public int candy(int[] ratings) {
		if (ratings.length == 0) return 0;
		if (ratings.length == 1) return 1;

		int[] left2right = new int[ratings.length];
		Arrays.fill(left2right, 1);
		int[] right2left = new int[ratings.length];
		Arrays.fill(right2left, 1);

		for (int i = 1; i < left2right.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left2right[i] = left2right[i - 1] + 1;
			} else {
				left2right[i] = 1;
			}
		}

		for (int i = right2left.length - 2; i >= 0; i--) {
			if (ratings[i + 1] < ratings[i]) {
				right2left[i] = right2left[i + 1] + 1;
			} else {
				right2left[i] = 1;
			}
		}

		int sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			sum += Math.max(left2right[i], right2left[i]);
		}

		return sum;
	}
}
