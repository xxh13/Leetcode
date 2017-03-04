package leetcode_40_60;

import java.util.regex.Pattern;

/**
 *
 * Created by john on 2017/3/1.
 */
public class _44 {

    public static void main(String[] args) {
        _44 demo =  new _44();
        System.out.println(demo.isMatch("aa", "*?*?"));
    }

    public boolean isMatch(String s, String p) {
        char[] s_array = s.toCharArray();
        char[] p_array = p.toCharArray();

        if(s_array.length == 0 && p_array.length != 0) {
            for (int i = 0; i < p_array.length; i++) {
                if (p_array[i] != '*') return false;
            }

            return true;
        }

        int i = 0, j = 0;

        while (i < s_array.length && j < p_array.length) {
            if (s_array[i] == p_array[j]) {
                i++;
                j++;
            } else if (p_array[j] == '?'){
                i++;
                j++;
            } else if (p_array[j] == '*'){
                if (j == p_array.length - 1) {
                    return true;
                } else {
                    while (j < p_array.length - 1 && p_array[++j] == '*'){}
                    //like "*?"
                    if (p_array[j] == '?'){
                        i = s_array.length;
                        j++;
                        break;
                    }
                    int length = 0;
                    while (j + length < p_array.length && p_array[j + length] != '?' && p_array[j + length] != '*') {
                        length++;
                    }
                    //贪婪匹配，从最长的子串开始匹配，并且匹配最后一个出现的子串

                    int m = i, init = i;
                    boolean find = false;
                    while (i < s_array.length) {
                        //首先找到相近的子字符串
                        while (i < s_array.length && s_array[i] != p_array[j]) {
                            i++;
                        }
                        int k = 0;
                        for (; k < length && i + k < s_array.length; k++) {
                            if (i + k < s_array.length && s_array[i + k] != p_array[j + k]) {
                                break;
                            }
                        }
                        if (k == length) {
                            m = i;
                            find = true;
                        }
                        i++;
                    }
                    if (find) {
                        i = m + length;
                        j += length;
                    } else {
                        return false;

                    }
                }
            } else {
                return false;
            }
        }

        if (i != s_array.length) {
            return false;
        }
        if (j != p_array.length) {
            for (int k = j; k < p_array.length; k++) {
                if (p_array[k] != '*') {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
