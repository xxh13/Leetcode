package leetcode_170_200;

import org.junit.Test;

public class _201 {

	@Test
	public void test() {
		System.out.println(rangeBitwiseAnd(0, 2147483647));
	}

	public int rangeBitwiseAnd(int m, int n) {
		long result = m;
		for (long i = m + 1; i <= (long) n; i++) {
			result = result & (i);
		}
		return (int) result;
	}
}
