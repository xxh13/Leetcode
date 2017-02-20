package leetcode_20_40;

import java.util.stream.IntStream;

/**
 *
 * Created by XXH on 2017/2/18.
 */
public class _27 {

    public static void main(String[] args) {
        _27 demo = new _27();
        int[] nums = {3,3,3,3,4,4};
        System.out.println(demo.removeElement(nums, 3));
        IntStream.of(nums).forEach(e -> System.out.print(e + " "));
    }


    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int count = 0;

        if (nums.length == 0) return nums.length;
        if (nums.length == 1) return nums[0] == val ? 0 : 1;

        int i = 0, j = length - 1;
        while (i < j) {
            while (i < j && nums[i] != val) {
                i++;
            }
            if (nums[i] == val) {
                count++;
            }
            while (i < j && nums[j] == val) {
                j--;
                count++;
            }
            nums[i] = nums[j];
            i++;
            j--;
        }
        if (i == j && nums[i] == val) count++;

        return length - count;
    }
}
