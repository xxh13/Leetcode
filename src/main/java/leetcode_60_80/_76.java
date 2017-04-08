package leetcode_60_80;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.LinkedList;

public class _76 {

    public static void main(String[] args) {
        _76 demo = new _76();
        String s = args[1];
        String t = args[2];
        System.out.println("s:" + s);
        System.out.println("t:" + t);
        System.out.println(demo.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int[] table = new int[53];
        int length = t.length();
        int start = 0, end = s.length();
        char[] t_array = t.toCharArray();
        for(int i = 0; i < t_array.length; i++){
            table[getIndex(t_array[i])]++;
        }

        char[] array = s.toCharArray();
        int[] sign = new int[array.length];

        int count = 0;
        int[] tempTable = new int[53];
        int i = 0, j = i;
        while (j < array.length) {
            int index = getIndex(array[j]);
            if (table[index] != 0) {
                if (tempTable[index] < table[index]){
                    count++;
                }
                tempTable[index]++;
                while (count == length){
                    if(j - i < end - start){
                        end = j;
                        start = i;
                    }
                    int k = getIndex(array[i]);
                    if(table[k] != 0){
                        if (table[k] >= tempTable[k]){
                            count--;
                        }
                        tempTable[k]--;
                    }
                    i++;
                }
            }
            j++;
        }
        if (start == 0 && end == s.length()) return "";

        return s.substring(start, end + 1);
    }

    private int getIndex(char c) {
        if (c >= 'a' && c <= 'z'){
            return c - 'a';
        }
        else if (c >= 'A' && c <= 'Z'){
            return c - 'A' + 26;
        }
        else if(c == '_'){
            return 52;
        }
        return 0;
    }
}
