package DP;

/**
 * num : 198
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 * Created by XXH on 2016/8/20.
 */
public class Robber {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;

        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        if(nums.length == 1) return sum[0];
        sum[1] = nums[0] > nums[1] ? nums[0] : nums[1];

        for(int i = 2; i < nums.length; i++){
            sum[i] = sum[i-1] > sum[i-2] + nums[i] ? sum[i-1] : sum[i-2] + nums[i];
        }

        return sum[nums.length-1];
    }
}
