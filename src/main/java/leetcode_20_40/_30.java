package leetcode_20_40;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters
 * Created by XXH on 2017/2/19.
 */
public class _30 {

    public static void main(String[] args) {
        _30 demo = new _30();
        String s = "barfoofoobarthefoobarman";
        String words[] = {"bar", "foo", "the"};

        demo.findSubstring(s, words).forEach(System.out::println);
    }


    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();

        //invalid situations
        if (s == null || words == null || s.length() == 0 || words.length == 0) return result;

        //build a map with words
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        int wordLength = words[0].length();

        //outer looper with the length of one word in words
        for (int i = 0; i < wordLength; i++) {
            int count = 0, index = i;
            HashMap<String, Integer> curMap = new HashMap<>();
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                if (map.containsKey(word)) {
                    if (curMap.containsKey(word)) {
                        curMap.put(word, curMap.get(word) + 1);
                    } else {
                        curMap.put(word, 1);
                    }

                    if (curMap.get(word) <= map.get(word)) {
                        count ++;
                    } else {
                        //smart way!!!
                        while (curMap.get(word) > map.get(word)) {
                            String temp = s.substring(index, index + wordLength);
                            curMap.put(temp, curMap.get(temp) - 1);
                            if (curMap.get(temp) == 0) {
                                count--;
                            }
                            index += wordLength;
                        }
                    }

                    if (count == words.length) {
                        result.add(index);
                        String temp = s.substring(index, index + wordLength);
                        curMap.put(temp, curMap.get(temp) - 1);
                        count --;
                        index += wordLength;
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    index = j + wordLength;
                }
            }
        }


        return result;
    }
}
