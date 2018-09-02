package leetcode_170_200;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _242 {

	@Test
	public void test() {
		assert isAnagram("abc", "cba");
		assert !isAnagram("abc", "abb");
		assert isAnagram("abcdb", "abbcd");
	}

	public boolean isAnagram(String s, String t) {

		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();

		if (sArray.length != tArray.length) {
			return false;
		}

		Map<Character, Long> sMap = IntStream.range(0, sArray.length).mapToObj(i -> sArray[i])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<Character, Long> tMap = IntStream.range(0, sArray.length).mapToObj(i -> tArray[i])
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));



		return sMap.equals(tMap);
	}
}
