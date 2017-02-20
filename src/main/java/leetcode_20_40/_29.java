package leetcode_20_40;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * Created by XXH on 2017/2/19.
 */
public class _29 {

    public static void main(String[] args) {
        _29 demo = new _29();
        System.out.println(demo.divide(-2147483648, 1));
    }

    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        if (divisor == 0) return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        char sign = '+';
        if ( (dividend < 0 && divisor > 0)
                || (dividend > 0 && divisor < 0))
        {
            sign = '-';
        }

        long divid = Math.abs((long) dividend);
        long divis  = Math.abs((long) divisor);

        int result = 0;
        while (divid >= divis) {
            long mul = divis, add = 1;
            while (divid >= (mul << 1)) {
                mul <<= 1;
                add <<= 1;
            }
            divid -= mul;
            result += add;
        }

        return sign == '+' ? result : -result;
    }
}
