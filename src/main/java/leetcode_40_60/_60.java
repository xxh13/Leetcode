package leetcode_40_60;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by john on 2017/3/9.
 */
public class _60 {

    public static void main(String[] args) {
        _60 demo = new _60();
        System.out.println(demo.getPermutation(9, 54494));
    }

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        int[] factorial = new int[n];
        StringBuilder sb = new StringBuilder();

        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k --;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.remove(index));
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}
