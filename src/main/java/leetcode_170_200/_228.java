package leetcode_170_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _228 {

	@Test
	public void test() {
		int[] array = {};
		summaryRanges(array).forEach(System.out::println);
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();

		for (int i = 0; i < nums.length;) {
			StringBuilder sb = new StringBuilder();
			sb.append(nums[i]);
			int j = i + 1;
			while (j < nums.length && nums[j] == nums[j - 1] + 1) {
				j++;
			}
			if (j != i + 1) {
				sb.append("->" + nums[j - 1]);
			}
			list.add(sb.toString());
			i = j;

		}

		return list;
	}
}
