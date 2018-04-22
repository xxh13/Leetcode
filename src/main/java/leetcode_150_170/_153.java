package leetcode_150_170;

public class _153 {

    public static void main(String[] args) {
        int[] nums = {};
        _153 demo = new _153();
        System.out.println(demo.findMin(nums));
    }

    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i + 1 < j) {
            int mid = (i + j) / 2;
            // if the array is not rotated
            if (nums[mid] < nums[j]) {
                j = mid;
            } else {
                i = mid;
            }
        }

        return nums[i] < nums[j] ? nums[i] : nums[j];
    }
}
