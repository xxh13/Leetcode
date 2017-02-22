package leetcode_01_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an nums S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the nums which gives the sum of zero
 * Created by XXH on 2017/1/17.
 */
public class _15 {

    public static void main(String[] args) {
        _15 demo = new _15();
        int[] array = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        demo.threeSum(array).forEach(System.out::println);
    }


    // method 1 time complexity O(n^2)
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the nums
        Arrays.sort(nums);

        List<List<Integer> > result = new LinkedList<>();

        //invalid situations
        if (nums.length < 3) return result;
        if (nums[0] > 0 || nums[nums.length - 1] < 0) return result;

        for (int i = 0; (i < nums.length - 2) && (nums[i] <= 0); i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])){
                //calculate the sum of other two elements
                int sum = 0 - nums[i];
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                        result.add(list);

                        //avoid duplicate element
                        while (low < high && nums[low] == nums[low + 1] && nums[high] == nums[high - 1]) {
                            low++;
                            high--;
                        }
                        high--;
                        low++;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }


        return result;
    }
}
