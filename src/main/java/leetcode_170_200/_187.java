package leetcode_170_200;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class _187 {


    @Test
    public void test1() {
        List<String> list = findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        list.forEach(System.out::println);
    }



    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> intSet = new HashSet<>();
        Set<String> list = new HashSet<>();
        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;

        for (int i = 0; i < chars.length - 9; i++) {
            int v = 0;
            for (int j = 0; j < 10; j++) {
                v <<= 2;
                v |= map[chars[i + j] - 'A'];
            }

            if (!intSet.add(v)) {
                list.add(s.substring(i, i + 10));
            }
        }

        return new ArrayList<>(list);
    }
}
