package leetcode_20_40;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand
 * You are given a target value to search. If found in the array return its index, otherwise return -1
 * Created by john on 2017/2/21.
 */
public class _33 {

    public static void main(String[] args) {
        _33 demo = new _33();
        int nums[] = {4, 1, 2, 3};
        System.out.println(demo.search1(nums, 1));
    }

    /**
     *  reference: https://discuss.leetcode.com/topic/34491/clever-idea-making-it-simple
     * @param nums : sorted but is rotated at some pivot unknown
     * @param target
     * @return : index of target
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = (low + high) / 2;

            //如果 mid 和 target 的值不在同一边，则 mid 和 target 处于2个有序数组中
            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (num < target)
                low = mid + 1;
            else if (num > target)
                high = mid;
            else
                return mid;
        }

        return -1;
    }

    /**
     * reference :
     * @param nums
     * @param target
     * @return
     */

    public int search1(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        //if low does not change, then the array has not been rotated
        int pivotIndex = (low == 0) ? nums.length : low;
        //0 ~ pivotIndex - 1 is sorted
        //pivotIndex ~ num.length is sorted
        low = nums[0] <= target ? 0 : pivotIndex;
        high = nums[0] <= target ? pivotIndex : nums.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
