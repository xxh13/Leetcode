package leetcode_20_40;

import java.util.List;
import java.util.stream.IntStream;

/**
 * remove the duplicates in place such that each element appear only once and return the new length
 * Created by XXH on 2017/2/18.
 */
public class _26 {

    public static void main(String[] args) {
        _26 demo = new _26();
        int[] nums = {1,1};
        System.out.println(demo.removeDuplicates(nums));
        IntStream.of(nums).forEach(e -> System.out.print(e + " "));
    }

    /*
     *   @para:nums is sorted nums
     */
    public int removeDuplicates(int[] nums) {
        int length = nums.length;

        if (length <= 1) return nums.length;

        int i = 0, j = 1;
        while (j < length) {
            if (nums[i] < nums[j]) {
                i++;
                j++;
            }
            else {
                while (j < length && nums[i] == nums[j]) {
                    j++;
                }
                if (j < length) {
                    nums[++i] = nums[j];
                }
            }
        }

        return i + 1;
    }

}
