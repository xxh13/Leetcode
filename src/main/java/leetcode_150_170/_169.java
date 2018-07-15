package leetcode_150_170;

public class _169 {

    public static void main(String[] args) {
        _169 runner = new _169();
        int[] nums = {3,2,3};
        System.out.println(runner.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 0, result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    count = 0;
                    result = nums[i];
                }
            }
        }
        return result;
    }


}
