package leetcode_170_200;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class _239 {

	@Test
	public void test() {
		int[] array = {8, 7, 6, 5, 4, 3, 2, 1};
		IntStream.of(maxSlidingWindow(array, 3)).forEach(System.out::println);
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) return new int[0];

		PriorityQueue<Integer> heap = new PriorityQueue<>(k, (e1, e2) -> e2 - e1);
		int[] maxSlidingWindow = new int[nums.length - k + 1];

		for (int i = 0; i <= nums.length - k; i++) {
			//if i is 0, init the stack
			if (i == 0) {
				for (int j = i; j < k; j++) {
					heap.add(nums[j]);
				}
			} else {
				heap.remove(nums[i -1]);
				heap.add(nums[i + k - 1]);

			}
			maxSlidingWindow[i] = heap.peek();
		}

		return maxSlidingWindow;
	}
}
