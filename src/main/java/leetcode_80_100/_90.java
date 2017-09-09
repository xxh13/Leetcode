package leetcode_80_100;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Created by XXH on 2017/9/3.
 */
public class _90 {

    public static void main(String[] args) {
        _90 demo = new _90();
        int[] nums = {1};
        List<List<Integer>> subsets = demo.subsetsWithDup(nums);
        for (List<Integer> list : subsets) {
            list.forEach(e -> System.out.print(e + ","));
            System.out.println();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        List<Integer> set = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            getSubsets(nums, subsets, set, i, 0, 0);
        }

        return subsets;
    }

    private void getSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> set, int count, int n, int start) {
        if (n == count) {
            subsets.add(new LinkedList<>(set));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            while (i != start && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }

            if (i >= nums.length)
                continue;
            set.add(nums[i]);
            getSubsets(nums, subsets, set, count, n + 1, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
