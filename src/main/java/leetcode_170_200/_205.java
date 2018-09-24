package leetcode_170_200;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _205 {

	@Test
	public void test() {
		String s = "abab";
		String t = "baba";

		assert isIsomorphic(s, t);
	}

	public boolean isIsomorphic(String s, String t) {
		Map<Character, Integer> m1 = new HashMap<>();
		Map<Character, Integer> m2 = new HashMap<>();

		for(Integer i = 0; i < s.length(); i++) {

			if(m1.put(s.charAt(i), i) != m2.put(t.charAt(i), i)) {
				return false;
			}
		}
		return true;
	}
}
