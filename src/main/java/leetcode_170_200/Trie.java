package leetcode_170_200;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    @Test
    public void test() {
        Trie obj = new Trie();
        obj.insert("apple");
        assert !obj.search("app");
        assert obj.search("apple");
        assert obj.startsWith("a");
    }

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            boolean hasPrefix = false;
            for (TrieNode trieNode : cur.childNodes) {
                if (trieNode.c == c) {
                    hasPrefix = true;
                    cur = trieNode;
                }
            }
            if (!hasPrefix) {
                TrieNode child = new TrieNode(c);
                cur.childNodes.add(child);
                cur = child;
            }
        }
        cur.count += 1;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            boolean hasPrefix = false;
            for (TrieNode node : cur.childNodes) {
                if (node.c == c) {
                    hasPrefix = true;
                    cur = node;
                }
            }
            if (!hasPrefix) return false;
        }

        return cur.count > 0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        TrieNode cur = root;
        for (char c : chars) {
            boolean hasPrefix = false;
            for (TrieNode node : cur.childNodes) {
                if (node.c == c) {
                    hasPrefix = true;
                    cur = node;
                }
            }
            if (!hasPrefix) return false;
        }

        return true;
    }

    private static class TrieNode {
        private int count;
        private char c;
        private List<TrieNode> childNodes;

        TrieNode() {
            this.count = 0;
            this.c = '0';
            this.childNodes = new ArrayList<>();
        }

        TrieNode(char c) {
            this.count = 0;
            this.c = c;
            this.childNodes = new ArrayList<>();
        }
    }
}
