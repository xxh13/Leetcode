package leetcode_60_80;

import java.util.Arrays;


public class _80 {

    public static void main(String[] args) {
        _80 demo = new _80();
        int[] nums = new int[args.length - 1];
        for (int i = 1; i < args.length; i++){
            nums[i - 1] = Integer.parseInt(args[i]);
        }
        Arrays.sort(nums);
        int length = demo.removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }
    /**
     * remove duplicates in the array,the duplicates are allowed twice
     * @param : nums are sorted
     */
    public int removeDuplicates(int[] nums){
        int i = 0, j = i;
        int length = nums.length;

        while(i < length) {
            j = i;
            while(j < length && nums[i] == nums[j]) {
                j++;
            }
            if (j - i > 2) {
                System.arraycopy(nums, j - 2, nums, i, length - j + 2);
                length = length - (j - i - 2);
                i = i + 2;
            }else {
                i = j;
            }
        }

        return length;
    }
}
