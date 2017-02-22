package leetcode_20_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Created by john on 2017/2/22.
 */
public class _40 {

    public static void main(String[] args) {
        _40 demo = new _40();
        int[] candidates = {1, 1, 1, 3, 3};
        int target = 5;
        demo.combinationSum2(candidates, target).forEach(System.out::println);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List <Integer>> combinations = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);

        combination(candidates, 0, combinations, combination, target);
        return combinations;
    }

    private void combination(int[] candidates, int start, List<List <Integer>> combinations,
                             List<Integer> combination, int target)
    {
        if (target == 0) combinations.add(new ArrayList<>(combination));

        if (start >= candidates.length) return;

        for (int i = start; i < candidates.length; i++) {
            //avoid duplicate
            while (i > start && i < candidates.length && candidates[i] == candidates[i-1]) {
                i++;
            }


            //to see it is necessary to continue the loop
            if (i < candidates.length && target >= candidates[i]) {
                combination.add(candidates[i]);
                combination(candidates, i + 1, combinations, combination, target - candidates[i]);
                combination.remove(combination.size() - 1);
            } else {
                break;
            }
        }
    }
}
