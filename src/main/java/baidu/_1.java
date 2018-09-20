package baidu;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _1<T extends Comparable> {

	@Test
	public void test() {
		_1<Integer> demo = new _1<>();
		Integer[] nums = {2, 4, 5, 4, 7, 7};
		demo.solve(nums).forEach(System.out::println);
	}

	public List solve(T[] nums) {
		if (nums == null) throw new NullPointerException();

		Stack<T> stack = new Stack<>();
		List<T> result = new LinkedList<>();

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1) {
				stack.push(nums[i]);
				result.add(0, null);
			}
			else {
				while (!stack.isEmpty() && nums[i].compareTo(stack.peek()) >= 0) {
					stack.pop();
				}
				result.add(0, stack.isEmpty() ? null : stack.peek());
				stack.push(nums[i]);
			}
		}

		return result;
	}
}
