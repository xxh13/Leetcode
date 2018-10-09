package leetcode_170_200;

import java.util.ArrayList;
import java.util.List;

class WordDictionary {

	Entry[] entry;

	/** Initialize your data structure here. */
	public WordDictionary() {
		entry = new Entry[26];
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		char[] chars = word.toCharArray();

		Entry[] children = entry;
		Entry e = new Entry();
		for (char c : chars) {
			if (children[c - 'a'] == null) {
				e = new Entry();
				children[c - 'a'] = e;
			}
			children = children[c - 'a'].children;
		}
		e.exist = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		List<Entry[]> entries = new ArrayList<>();
		entries.add(entry);

		return subSearch(word.toCharArray(), 0, entries);
	}

	private boolean subSearch(char[] chars, int index, List<Entry[]> entryArray) {
		if (entryArray.isEmpty()) {
			return false;
		}

		if (index == chars.length) {
			return true;
		}

		if (index == chars.length - 1 && chars[index] == '.') {
			for (Entry[] entries : entryArray) {
				for (int i = 0; i < 26; i++) {
					if (entries[i] != null && entries[i].exist) {
						return true;
					}
				}
			}
			return false;
		}

		for (Entry[] entries : entryArray) {
			List<Entry[]> list = new ArrayList<>();
			if (chars[index] == '.') {
				for (int i = 0; i < 26; i++) {
					if (entries[i] != null) {
						list.add(entries[i].children);
					}
				}
			}
			else if (entries[chars[index] - 'a'] != null) {
				if (index == chars.length - 1 && !entries[chars[index] - 'a'].exist) {
					return false;
				}
				list.add(entries[chars[index] - 'a'].children);
			}

			boolean exist = subSearch(chars, index + 1, list);
			if (exist) {
				return true;
			}
		}

		return false;
	}

	private static class Entry {
		Entry[] children = new Entry[26];
		boolean exist = false;
	}

}
