package leetcode_80_100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Created by XXH on 2017/9/3.
 */
public class _89 {

    public static void main(String[] args) {
        _89 demo = new _89();
        demo.grayCode(3).forEach(System.out::println);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

    private String neighbour(String seq, int n) {
        char[] chars = seq.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if (i != n) {
                chars[i] = chars[i] == '0' ? '1' : '0';
            }
        }
        return new String(chars);
    }

    private int binary2int(String seq) {
        char[] chars = seq.toCharArray();
        int len = chars.length;
        int result = 0;
        for (int i = 0; i < len; i++) {
            result += (1 << len - i - 1) * (chars[i] - '0');
        }
        return result;
    }
}
