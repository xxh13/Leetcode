package leetcode_150_170;

public class _162 {


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] nums = {1, 2};
        _162 demo = new _162();
        System.out.println(demo.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int i = 0;
        while (i < nums.length) {
            if (i == 0) {
                if (i + 1 >= nums.length || nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            }
            else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            i++;
        }

        return -1;
    }
}
