package leetcode_150_170;

public class _154 {

    public static void main(String[] args) {
        int nums[] = {2, 0, 1, 1, 1};
        _154 demo = new _154();
        System.out.println(demo.findMin(nums));
    }

    private int findMin(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i + 1 < j) {
            int mid = (i + j) / 2;
            // if the array is not rotated
            if (nums[mid] < nums[j]) {
                j = mid;
            } else if (nums[mid] > nums[j]){
                i = mid;
            } else {
                int leftMin = findMin(nums, i, mid);
                int rightMin = findMin(nums, mid, j);
                return leftMin < rightMin ? leftMin : rightMin;
            }
        }

        return nums[i] < nums[j] ? nums[i] : nums[j];
    }

    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

}
