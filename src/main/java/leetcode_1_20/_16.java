package leetcode_1_20;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * Created by XXH on 2017/1/18.
 */
public class _16 {

    public static void main(String[] args) {
        _16 demo = new _16();
        int sums[] = {-3,-2,-5,3,-4};
        int closestSum = demo.threeSumClosest(sums, 1);

        System.out.println(closestSum);
    }


    public int threeSumClosest(int[] nums, int target) {
        // sort the array
        Arrays.sort(nums);

        //assume the sum as the closest
        int sum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == target) {
                    sum = target;
                    while (low < high && nums[low] == nums[++low]);
                    while (low < high && nums[high] == nums[--high]);
                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < target) {
                    if (Math.abs(nums[i] + nums[low] + nums[high] - target) < Math.abs(sum-target)) {
                        sum = nums[i] + nums[low] + nums[high];
                    }
                    low++;
                } else {
                    if (Math.abs(nums[i] + nums[low] + nums[high] - target) < Math.abs(sum-target)) {
                        sum = nums[i] + nums[low] + nums[high];
                    }
                    high--;
                }
            }
        }

        return sum;
    }
}
