package leetcode_40_60;

import java.util.*;

/**
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Created by john on 2017/2/25.
 *
 */
public class _47 {

    public static void main(String[] args) {
        _47 demo = new _47();
        int[] nums = {};
        demo.permuteUnique(nums).forEach(System.out::println);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new LinkedList<>();
        List<Integer> permutation = new LinkedList<>();
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        permute(nums, used, 0, permutations, permutation);
        return permutations;
    }


    private void permute(int[] nums, int[] used, int count,  List<List<Integer>> permutations,
                         List<Integer> permutation)
    {
        if (count == nums.length) {
            permutations.add(new LinkedList<>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //when a number has the same value with its previous, we can use this number only if his previous is used
            if(i > 0 && nums[i-1]==nums[i] && used[i-1] != 0) continue;
            if (used[i] == 0) {
                permutation.add(nums[i]);
                used[i] = 1;
                count++;
                permute(nums, used, count, permutations, permutation);
                count--;
                used[i] = 0;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
