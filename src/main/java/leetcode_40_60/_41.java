package leetcode_40_60;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * Created by john on 2017/2/22.
 */
public class _41 {

    public static void main(String[] args) {
        _41 demo = new _41();
        int[] nums = {1,1};
        System.out.println(demo.firstMissingPositive(nums));
    }


    /**
     * reference : https://discuss.leetcode.com/topic/8293/my-short-c-solution-o-1-space-and-o-n-time/2
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i+1 && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        IntStream.of(nums).forEach(e -> System.out.print(e + " "));
        System.out.println();

        int i = 0;
        for ( ; i < nums.length && nums[i] > 0; i++) {
            if (nums[i] != i+1) return i + 1;
        }
        return i == 0 ? 1 : nums[i - 1] + 1;
    }
}
