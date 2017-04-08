package leetcode_60_80;

import java.util.stream.IntStream;

public class _75 {

    public static void main(String[] args){
        _75 demo = new _75();
        int[] nums = new int[args.length - 1];
        for(int i = 1; i < args.length; i++) {
            nums[i - 1] = Integer.parseInt(args[i]);
        }
        demo.sortColors(nums);
        IntStream.of(nums).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public void sortColors(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;
        while (i < length && j < length) {
            while(i < length && nums[i] == 0) i++;
            j = i;
            while(j < length && nums[j] != 0) j++;
            if (i < length && j < length)
                swap(i, j , nums);
        }
        i = nums.length - 1;
        j = i;
        while(i >= 0 && j >= 0) {
            while(i >= 0 && nums[i] == 2) i--;
            j = i;
            while(j >= 0 && nums[j] != 2) j--;
            if (i >= 0 && j >= 0)
                swap(i, j, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
