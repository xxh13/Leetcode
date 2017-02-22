package leetcode_01_20;

/**
 * Implement atoi to convert a string to an integer.
 * Created by XXH on 2017/1/29.
 */
public class _8 {

    public static void main(String[] args) {
        String str = "     +004500";
        _8 demo = new _8();
        System.out.println(demo.myAtoi(str));
    }

    public int myAtoi(String str) {
        long result = 0;

        char[] array = str.toCharArray();
        int index = 0, length = array.length;
        char sign = '+';
        boolean getTheFirstDigit = false;

        if (length == 0) return 0;

        //takes an optional initial plus or minus sign
        while (index < length) {
            if (array[index] != ' ') {
                if (array[index] == '-') {
                    sign = '-';
                }
                else if (array[index] != '+' && !isDigital(array[index])) {
                    return 0;
                }
                break;
            }
            index++;
        }

        if (index >= length) return 0;
        if (!isDigital(array[index])) {
            index++;
        }

        //calculate the value
        while (index < length) {
            if (isDigital(array[index])) {
                if (array[index] != 0)
                    getTheFirstDigit = true;
                result = result * 10 + ( array[index] - '0' + 0);
            }
            else {
                if (!getTheFirstDigit) return 0;
                else break;
            }

            if (sign == '-') {
                if (0 - result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            } else {
                if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }

            index++;
        }

        if (sign == '-') {
            return (int) (0 - result);
        } else {
            return (int) result;
        }
    }

    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }
}
