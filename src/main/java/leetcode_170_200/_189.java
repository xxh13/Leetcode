package leetcode_170_200;

public class _189 {

    public void rotate(int[] nums, int k) {
        int move = k % nums.length;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[(i + move) % nums.length] = nums[i];
        }
        System.arraycopy(result, 0, nums, 0, result.length);
    }
}
