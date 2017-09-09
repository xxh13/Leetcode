package leetcode_80_100;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * Created by XXH on 2017/9/5.
 */
public class _93 {

    public static void main(String[] args) {
        _93 demo = new _93();
        demo.restoreIpAddresses("00100").forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        char[] chars = s.toCharArray();
        List<String> addresses = new LinkedList<>();
        StringBuilder sb = new StringBuilder("");
        restoreIpAddresses(addresses, chars, 0, sb, 1);
        return addresses;
    }

    private void restoreIpAddresses(List<String> addresses, char[] chars, int start, StringBuilder sb, int count) {
        // ip address consistent of 4 parts
        if (count == 4) {
            if (isValidAddress(chars, start, chars.length - 1)) {
                sb.append(chars, start, chars.length - start);
                addresses.add(sb.toString());
                sb.delete(sb.length() - (chars.length - start), sb.length());
            }
            return;
        }
        if (count < 4) {
            for (int i = start; i < start + 3 && i < chars.length; i++) {
                sb.append(chars, start, i - start + 1);
                sb.append(".");
                if (isValidAddress(chars, start, i)) {
                    restoreIpAddresses(addresses, chars, i + 1, sb, count + 1);
                }
                sb.delete(sb.length() - 2 - (i - start) > 0 ? sb.length() - 2 - (i - start) : 0, sb.length());
            }
        }

    }

    private boolean isValidAddress(char[] chars, int start, int end) {
        if (start >= chars.length) return false;
        if (chars[start] == '0') {
            if (start == end) return true;
            return false;
        }
        int i = end;
        int j = 0;
        int num = 0;
        while (i >= start) {
            num = num + (chars[i] - '0') * (int) Math.pow(10, j);
            j++;
            i--;
        }
        return num >= 1 && num <= 255;
    }
}
