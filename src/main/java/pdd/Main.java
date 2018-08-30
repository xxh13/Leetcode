package pdd;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();

		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = scanner.nextLine();
		}

		new Main().solution(lines);
	}

	private void solution(String[] lines) {
		if (lines.length == 1) {
			System.out.println("-");
			return;
		}
		Set<String> words = Stream.of(lines).collect(Collectors.toSet());

		List<List<Character>> lists = new ArrayList<>();
		for (int j = 0; j < lines[0].length(); j++) {
			List<Character> list = new ArrayList<>();
			for (int i = 0; i < lines.length; i++) {
				if (!list.contains(lines[i].charAt(j)))
					list.add(lines[i].charAt(j));
			}
			Collections.sort(list);
			lists.add(list);
		}

		char[] word = new char[lists.size()];

		if (findWords(lists, words, word)) {
			System.out.println(word);
		} else {
			System.out.println("-");
		}
	}

	private int i = 0;

	private boolean findWords(List<List<Character>> lists, Set<String> words, char[] word) {
		if (i == lists.size() && !words.contains(new String(word))) {
			return true;
		}
		if (i >= lists.size()) return false;

		for (int n = 0; n < lists.get(i).size(); n++) {
			word[i] = lists.get(i).get(n);
			i++;
			if (findWords(lists, words, word)) {
				return true;
			}
			i--;
		}
		return false;
	}
}
