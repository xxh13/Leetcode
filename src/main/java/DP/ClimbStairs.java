package DP;

/**
 * num : 70
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 * Created by XXH on 2016/8/20.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1, b = 2, temp;
        for (int i = 2; i < n; i++) {
            temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }
}
