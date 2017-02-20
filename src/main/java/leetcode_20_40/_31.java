package leetcode_20_40;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * Created by john on 2017/2/20.
 */

public class _31 {

    public static void main(String[] args) {
        _31 demo = new _31();
        int[] nums = {1,2,3};
        demo.nextPermutation(nums);

        IntStream.of(nums).forEach(System.out::println);
    }


    /**
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) return;
        boolean hasChanged = false;

        //arrangement
        int i;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                hasChanged = true;
                int j = getSmallestIndex(nums, i, nums[i - 1]);
                int temp = nums[j];
                nums[j] = nums[i - 1];
                nums[i - 1] = temp;

                Arrays.sort(nums, i, nums.length);
                break;
            }
        }

        if (!hasChanged) {
            Arrays.sort(nums);
        }

    }

    private int getSmallestIndex(int[] nums, int start, int value) {
        int index = start;
        int small = nums[start] > value ? nums[start] : value;

        for (int i = start; i < nums.length; i++) {
            if (nums[i] < small && nums[i] > value) {
                index = i;
                small = nums[i];
            }
        }

        return index;
    }

}
