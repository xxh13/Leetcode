package leetcode_120_140;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _128 {

	@Test
	public void test() {
		int[] nums = {100};

		assert longestConsecutive(nums) == 1;
	}

	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		int length = 0;
		for (int e : nums) {
			if (!map.containsKey(e)) {
				int left = map.getOrDefault(e - 1, 0) ;
				int right = map.getOrDefault(e  + 1, 0);

				int sum = left + right + 1;
				map.put(e, sum);
				length = Math.max(sum, length);

				map.put(e - left, sum);
				map.put(e + right, sum);
			}
		}


		return length;
	}
}
