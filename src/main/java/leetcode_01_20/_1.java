package leetcode_01_20;

import java.util.stream.IntStream;

/**
 *
 * Created by XXH on 2017/1/9.
 */
public class _1 {

    public static void main (String[] args) {
        _1 demo = new _1();
        int[] nums = {3, 2 ,4};
        int result[] = demo.twoSum(nums, 6);
        IntStream.of(result).forEach(System.out::println);
    }

    public int[] twoSum(int[] nums, int target) {
        int result[] = {0, 0};

        int i = 0, j;
        for (; i < nums.length; i++) {
            for (j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;

                    return result;
                }
            }
        }

        return result;
    }

    private int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
