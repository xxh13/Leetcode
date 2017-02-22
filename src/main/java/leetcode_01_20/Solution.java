package leetcode_01_20;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by XXH on 2016/8/22.
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("dddccdbba"));
    }

    /*
     * 387
     * Given a string, find the first non-repeating character in it and return it's index.
     * If it doesn't exist, return -1.
     *
     */
    public int firstUniqChar(String s) {
        char array[] = s.toCharArray();
        List<Integer> sameLetter = new LinkedList<>();
        boolean unique;

        if (array.length == 1) return 0;

        for (int i = 0; i < array.length; i++) {
            unique = true;
            if (!sameLetter.contains(array[i] - 'a')) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        sameLetter.add(array[i] - 'a');
                        unique = false;
                        break;
                    }
                }
                if (unique ) return i;
            }

        }

        return -1;
    }
}
