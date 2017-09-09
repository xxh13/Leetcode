package leetcode_80_100;

/**
 * Search in Rotated Sorted Array II
 * Created by XXH on 2017/8/31.
 */
public class _81 {

    public static void main(String[] args) {
        _81 demo = new _81();
        int[] nums = {1, 3, 1, 1};
        int target = 3;
        System.out.println(demo.search(nums, target));
    }

    public boolean search(int[] nums, int target){
        if (nums.length == 0){
            return false;
        }
        if (nums.length == 1){
            return nums[0] == target;
        }
        int length = nums.length;
        // if not rotated
        if (nums[0] < nums[length - 1]) {
            return search(nums, target, 0, length);
        }
        int i = 0, j = length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[i] > nums[j]) {
                if (target == nums[i] || target == nums[j]){
                    return true;
                }
                if (target > nums[j]) {
                    while (j > 0 && nums[j] == nums[--j]){}
                }
                if (target < nums[i]) {
                    while (i < nums.length - 1 && nums[i] == nums[++i]){}
                }
            }else if (nums[i] < nums[j]) {
                if (nums[mid] > target) {
                    j = mid;
                } else if (nums[mid] < target) {
                    i = mid + 1;
                } else {
                    return true;
                }
            }
            else {
                if (nums[i] == target) return true;
                if (i == j) {
                    return nums[i] == target;
                }
                i++;
                j--;
            }
        }
        return false;
    }

    private boolean search(int[] nums, int target, int start, int end){
        int i = start, j = end;
        int mid = 0;
        while (i < j) {
            mid = nums[(i + j) / 2];
            if (mid > target) {
                j = (i + j) / 2;
            }else if(mid < target){
                i = (i + j) / 2 + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
