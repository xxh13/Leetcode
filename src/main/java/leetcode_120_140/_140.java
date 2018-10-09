package leetcode_120_140;

import org.junit.Test;

import java.util.*;

public class _140 {

	@Test
	public void test() {
		String s = "pineapplepenapple";
		List<String> list = List.of("apple", "pen", "applepen", "pine", "pineapple");
		wordBreak(s, list).forEach(System.out::println);
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		int length = s.length();

		boolean[] dp = new boolean[length];
		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < length; i++) {
			List<Integer> list = new ArrayList<>();
			if (wordDict.contains(s.substring(0, i + 1))) {
				dp[i] = true;
				list.add(-1);
			}
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
					dp[i] = true;
					list.add(j);
				}
			}
			if (!list.isEmpty()) {
				map.put(i, list);
			}

		}
		List<String> list = new LinkedList<>();

		if (!dp[length - 1]) {
			return list;
		}


		makeString(map, s, length - 1, new ArrayList<>(), list);

		return list;
	}

	private void makeString(Map<Integer, List<Integer>> map, String s, int start, List<String> words, List<String> list) {
		if (start == -1) {
			list.add(String.join(" ", words));
			return;
		}

		if (map.containsKey(start)) {
			for (int index : map.get(start)) {
				words.add(0, s.substring(index + 1, start + 1));
				makeString(map, s, index, words, list);
				words.remove(0);
			}
		}
	}
}
