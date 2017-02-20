package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Created by xuxh-fnst on 2016/7/14.
 */
public class CombinationSum {

    public static void main(String[] args){
        int[] nums = {2, 3, 4, 7};
        System.out.println(new CombinationSum().combinationSum(nums, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new LinkedList<>();
        List<Integer> item = new LinkedList<>();

        if (candidates == null || candidates.length == 0) return combination;

        Arrays.sort(candidates);
        helper(candidates, target, 0, item, combination);

        return combination;
    }

    private static void helper(int[] candidates, int target, int start, List<Integer> item,
                    List<List<Integer>> res)
    {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList<>(item));
            return ;
        }

        for (int i = start ; i < candidates.length; i++){
            if (i > 0 && candidates[i] == candidates[i-1]) continue;

            item.add(candidates[i]);
            int newtarget = target - candidates[i];
            helper(candidates, newtarget, i , item, res);

            item.remove(item.size() - 1);
        }
    }


}