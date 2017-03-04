package leetcode_40_60;

import java.util.stream.IntStream;

/**
 *
 * Created by john on 2017/3/3.
 */
public class _53 {

    public static void main(String[] args) {
        _53 demo = new _53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(demo.maxSubArray1(nums));
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] +  (dp[i - 1] > 0 ? dp[i - 1] : 0);
            if (dp[i] > max)
                max = dp[i];
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        return maxSubArray(nums, 0, nums.length - 1);
    }

    private int maxSubArray(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];

        int mid = (left + right) / 2;

        int maxLeft = maxSubArray(nums, left, mid);
        int maxRight = maxSubArray(nums, mid + 1, right);

        int sumLeft = Integer.MIN_VALUE, sumRight = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            sumLeft = sumLeft > sum ? sumLeft : sum;
        }
        sum = 0;
        for (int j = mid + 1; j <= right; j++) {
            sum += nums[j];
            sumRight = sumRight > sum ? sumRight : sum;
        }
        return maxOfThree(sumLeft + sumRight, maxLeft, maxRight);
    }

    private int maxOfThree(int a, int b, int c) {
        if (a > b) {
            return c > a ? c : a;
        } else {
            return c > b ? c : b;
        }
    }
}
