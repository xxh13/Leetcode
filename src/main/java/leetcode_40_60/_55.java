package leetcode_40_60;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * Created by john on 2017/3/4.
 */
public class _55 {

    public static void main(String[] args) {
        _55 demo = new _55();
        int[] nums = {0, 2, 3};
        if (demo.canJump(nums)){
            System.out.println("can jump");
        } else {
            System.out.println("cannot jump");
        }
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        int max = nums[0];
        for (int i = 0; i < max; i++) {
            max = i + nums[i] > max ? i + nums[i] : max;
            if (max >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
