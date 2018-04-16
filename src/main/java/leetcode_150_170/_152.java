package leetcode_150_170;


import java.util.stream.IntStream;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 */
public class _152 {

    public static void main(String[] args) {
        _152 demo = new _152();
        int[] nums = {-2, 0};
        int result = demo.maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //dp[i] 代表包含nums[i]的正的最大值produce
        int[] dp1 = new int[nums.length];
        //dp[i] 代表包含nums[i]的负的最大值produce
        int[] dp2 = new int[nums.length];

        dp1[0] = nums[0] > 0 ? nums[0] : 0;
        dp2[0] = nums[0] < 0 ? nums[0] : 0;

        for (int i = 1; i < nums.length; i++) {
            //如果当前为正数
            if (nums[i] > 0) {
                dp1[i] = dp1[i - 1] == 0 ? nums[i] : nums[i] * dp1[i - 1];
                dp2[i] = dp2[i - 1] == 0 ? 0 : nums[i] * dp2[i - 1];
            }
            // 如果当前为负数
            else if (nums[i] < 0){
                dp2[i] = dp1[i - 1] == 0 ? nums[i] : nums[i] * dp1[i - 1];
                dp1[i] = dp2[i - 1] == 0 ? 0 : dp2[i - 1] * nums[i];
            }
            // 如果当前值为0
            else {
                dp1[i] = 0;
                dp2[i] = 0;
            }
        }

        int result = IntStream.of(dp1).reduce(0, (e1, e2) -> e1 > e2 ? e1 : e2);

        return result;
    }
}
