package leetcode_170_200;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		char[] array = Long.toBinaryString(n).toCharArray();

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				count++;
			}
		}

		System.out.println(count);
	}
}
