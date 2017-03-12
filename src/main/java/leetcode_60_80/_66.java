package leetcode_60_80;

import java.util.stream.IntStream;

/**
 *
 * Created by john on 2017/3/12.
 */
public class _66 {

    public static void main(String[] args) {
        _66 demo = new _66();
        int[] digits = {1};
        IntStream.of(demo.plusOne(digits)).forEach(System.out::print);
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = num;
        }

        if (carry != 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        } else {
            return digits;
        }
    }
}
