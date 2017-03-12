package leetcode_60_80;

/**
 * Given two binary strings, return their sum (also a binary string).
 * Created by john on 2017/3/12.
 */
public class _67 {

    public static void main(String[] args) {
        _67 demo = new _67();
        String a = "111110";
        String b = "11";
        System.out.println(demo.addBinary(a, b));
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        char[] a_array = a.toCharArray();
        char[] b_array = b.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = a_array.length - 1, j = b_array.length - 1, carry = 0;

        while (i >= 0 && j >= 0) {
            int num = ((a_array[i] - '0') + (b_array[j] - '0') + carry) % 2;
            carry = ((a_array[i] - '0') + (b_array[j] - '0') + carry) / 2;
            sb.append(num);
            i--;
            j--;
        }

        while (i >= 0) {
            int num = ((a_array[i] - '0') + carry) % 2;
            carry = ((a_array[i] - '0') + carry) / 2;
            sb.append(num);
            i--;
        }

        while (j >= 0) {
            int num = ((b_array[j] - '0') + carry) % 2;
            carry = ((b_array[j] - '0') + carry) / 2;
            sb.append(num);
            j--;
        }

        if (carry != 0)
            sb.append(carry);

        sb.reverse();

        return sb.toString();
    }
}
