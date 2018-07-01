package leetcode_150_170;

import java.util.ArrayList;
import java.util.List;

public class _166 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        _166 demo = new _166();
        System.out.println(demo.fractionToDecimal(-2147483648, 1));
        System.out.println(demo.fractionToDecimal(1, -2147483648));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        long numeratorLong = (long) numerator, denominatorLong = (long) denominator;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            result.append('-');
            if (numerator < 0)
                numeratorLong = 0L - ((long) numerator);
            if (denominator < 0)
                denominatorLong = 0L - ((long) denominator);
        }
        long remain = numeratorLong % denominatorLong;
        result.append(numeratorLong / denominatorLong);
        List<Long> remainSet = new ArrayList<>();

        if (remain != 0) {
            result.append('.');
        }

        remainSet.add(remain);

        remain *= 10;
        while (remain != 0) {
            result.append(remain / denominatorLong);
            remain = remain % denominatorLong;
            if (!remainSet.contains(remain)) {
                remainSet.add(remain);
            } else {
                int offset = remainSet.size() - remainSet.indexOf(remain);
                int length = result.length();
                result.insert(length - offset, '(');
                result.append(')');
                break;
            }
            remain = remain * 10;
        }

        return result.toString();
    }
}
