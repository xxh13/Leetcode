package bytedance;

import org.junit.Test;

public class Main {

	@Test
	public void test() {
		String s = "145678";
		System.out.println(solution(s));
	}

	public String solution(String s) {
		int i, j;
		char[] chars = s.toCharArray();

		for (i = s.length() - 1; i > 0 && s.charAt(i) >= s.charAt(i - 1); i--);

		if (i == 0) {
			return null;
		}

		for (j = i; j < s.length() && s.charAt(j) < s.charAt(i - 1); j++);

		char c = s.charAt(i - 1);
		chars[i - 1] = chars[j - 1];
		chars[j - 1] = c;

		return new String(chars);
	}
}
