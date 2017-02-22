package leetcode_01_20;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Created by XXH on 2017/1/8.
 */
public class _3 {

    public static void main(String[] args) {
        _3 demo = new _3();
        System.out.println(demo.lengthOfLongestSubstring1("b"));
    }

    public int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int maxLength = 0;

        int i = 0, j = 0;
        for (; j < array.length; j++) {
            if (isIn(array, i , j, array[j])) {
                maxLength = j - i > maxLength ? j - i : maxLength ;
                i++;
                j = i;
            }
        }

        return j - i > maxLength ? j- i : maxLength;
    }

    private boolean isIn(char[] array, int start, int end, char c) {
        for (int i = start; i < end; i++) {
            if (array[i] == c) return true;
        }

        return false;
    }

}
