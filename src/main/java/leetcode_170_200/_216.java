package leetcode_170_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _216 {

	@Test
	public void test() {
		int k = 3;
		int n = 15;

		combinationSum3(k, n).forEach(System.out::println);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();

		combinationSum(list, nums, 1, k, n);

		return list;
	}

	/**
	 *
	 * @param list
	 * @param nums
	 * @param count : the num
	 * @param sum : the sum
	 */
	private void combinationSum(List<List<Integer>> list, List<Integer> nums, int start, int count, int sum) {
		if (sum < 0 || start > 10) {
			return;
		}

		if (count == 0 && sum == 0) {
			list.add(new ArrayList<>(nums));
			return;
		}

		for (int i = start; i < 10; i++) {
			nums.add(i);
			combinationSum(list, nums, i + 1, count - 1, sum - i);
			nums.remove(nums.size() - 1);
		}
	}
}
