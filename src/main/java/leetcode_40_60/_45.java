package leetcode_40_60;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * Created by john on 2017/2/24.
 */
public class _45 {

    public static void main(String[] args) {
        _45 demo = new _45();
        int[] nums = new int[25000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i;
        }
        demo.jump(nums);
    }

    /**
     * DP solution but time cost is huge!
     * @param nums
     * @return
     */
    public int jump1(int[] nums) {
        if (nums.length == 0) return 1;

        long[] steps = new long[nums.length];

        for (int i = nums.length - 2; i >= 0; i--) {
            steps[i] = Integer.MAX_VALUE;
            //if we can reach the end directly
            if (nums[i] >= nums.length - i - 1) {
                steps[i] = 1;
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    steps[i] = Math.min(steps[i], steps[i + j] + 1);
                    //it is always the shortest
                    if (steps[i + j] == 1) break;
                }
            }
        }
        LongStream.of(steps).forEach(System.out::println);
        return (int) steps[0];
    }

    public int jump(int[] nums) {
        if (nums.length < 2) return 0;

        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i + nums[i]);
        }

        return ret;
    }
}
