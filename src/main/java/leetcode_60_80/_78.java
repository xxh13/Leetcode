package leetcode_60_80;

import java.util.List;
import java.util.LinkedList;

public class _78 {
    public static void main(String[] args) {
        _78 demo = new _78();
        int[] nums = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            nums[i - 1] = Integer.parseInt(args[i]);
        }
        demo.subset(nums).forEach(System.out::println);
    }

    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> combinations = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            List<Integer> combination = new LinkedList<>();
            combine(combinations, combination, nums, 0, 0, i);
        }
        return combinations;
    }

    public void combine(List<List<Integer>> combinations, List<Integer> combination, int[] nums,
                        int start, int count, int n){
        if (count == n) {
            combinations.add(new LinkedList<>(combination));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            combination.add(nums[i]);
            count++;
            combine(combinations, combination, nums, i + 1, count, n);
            count--;
            combination.remove(combination.size() - 1);
        }
    }
}
