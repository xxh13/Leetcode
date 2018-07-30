package leetcode_170_200;

import org.junit.Test;

public class _220 {

    @Test
    public void test() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        assert !containsNearbyAlmostDuplicate(nums, k, t);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; i + j < nums.length && j <= k; j++) {
                long value_i = (long) nums[i];
                long value_j = (long) nums[j + i];

                if (Math.abs(value_i - value_j) <= (long) t) {
                    return true;
                }
            }
        }


        return false;
    }
}
