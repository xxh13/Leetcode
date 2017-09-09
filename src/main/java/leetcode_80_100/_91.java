package leetcode_80_100;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Decode Ways
 * Created by XXH on 2017/9/4.
 */
public class _91 {

    public static void main(String[] args) {
        _91 demo = new _91();
        String s = "227";
        demo.numDecodings(s);
    }


    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] array = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                if (chars[0] == '0') return 0;
                else array[i] = 1;
            }
            else if (i == 1){
                if (chars[i] == '0'){
                    if (chars[i - 1] > '2' || chars[i - 1] == '0') return 0;
                    else array[i] = 1;
                }else {
                    if (chars[i - 1] == '1') array[i] = 2;
                    else if (chars[i - 1] == '2') array[i] = chars[i] > '6' ? 1 : 2;
                    else array[i] = 1;
                }
            }
            else{
                if (chars[i] == '0') {
                    // cannot convert into message
                    if (chars[i - 1] > '2' || chars[i - 1] == '0') {
                        return 0;
                    } else {
                        array[i] = array[i - 2];
                    }
                } else {
                    if (chars[i - 1] == '1') {
                        array[i] = array[i - 1] + array[i - 2];
                    } else if (chars[i - 1] == '2') {
                        array[i] = array[i - 1] + array[i - 2] * (chars[i] > '6' ? 0 : 1);
                    } else {
                        array[i] = array[i - 1];
                    }
                }
            }
        }
        IntStream.of(array).forEach(System.out::println);
        return array[array.length - 1];
    }
}
