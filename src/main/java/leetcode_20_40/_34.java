package leetcode_20_40;

import java.util.stream.IntStream;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 * Created by john on 2017/2/21.
 */
public class _34 {

    public static void main(String[] args) {
        _34 demo = new _34();
        int[] nums = {1,2};
        IntStream.of(demo.searchRange1(nums, 1)).forEach(System.out::println);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int low = 0, high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                for (int i = mid; i >=0 && nums[i] == target; i--) result[0] = i;
                for (int i = mid; i < nums.length && nums[i] == target; i++) result[1] = i;

                return result;
            }
        }
        return result;
    }


    /**
     * reference : https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation/2
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int[] result = {-1, -1};

        int low = 0, high = nums.length;

        while (low < high) {
            int mid = (low + high ) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (nums[low] != target) return result;

        else result[0] = low;

        high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2 + 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        result[1] = high;

        return result;
    }

}
