package leetcode_170_200;

public class Test {


	@org.junit.Test
	public void testWordDictionary() {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bat");
		wordDictionary.addWord("at");
		wordDictionary.addWord("and");
		wordDictionary.addWord("an");
		wordDictionary.addWord("add");

		System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search("..."));

	}
}
