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
        IntStream.of(demo.searchRange(nums, 1)).forEach(System.out::println);
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


}
