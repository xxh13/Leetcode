package leetcode_40_60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * Created by john on 2017/2/23.
 */
public class _46 {

    public static void main(String[] args) {
        _46 demo = new _46();
        int[] nums = {1,2,3};
        demo.permute(nums).forEach(System.out::println);
    }

    /**
     * recursive method
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List< List<Integer>> permutations = new LinkedList<>();
        List<Integer> permutation = new LinkedList<>();
        int[] sign = new int[nums.length];

        permute(nums, sign, nums.length, permutations, permutation);

        return permutations;
    }

    private void permute(int nums[], int[] sign, int count, List< List<Integer>> permutations,
                         List<Integer> permutation)
    {
        if (count == 0)
            permutations.add(new LinkedList<>(permutation));

        for (int i = 0; i < nums.length; i++) {
            if (sign[i] != 1) {
                permutation.add(nums[i]);
                sign[i] = 1;
                count--;
                permute(nums, sign, count, permutations, permutation);
                count++;
                sign[i] = 0;
                permutation.remove(permutation.size() - 1);
            }
        }
    }


    /**
     *
     * https://discuss.leetcode.com/topic/6377/my-ac-simple-iterative-java-python-solution
     * @param num
     * @return
     */
    public List<List<Integer>> permute1(int[] num) {
        List<List<Integer>> ans = new ArrayList<>();
        if (num.length ==0) return ans;
        List<Integer> tempList = new ArrayList<>();
        tempList.add(num[0]);
        ans.add(tempList);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<>();
            for (int j = 0; j<=i; ++j){
                for (List<Integer> l : ans){
                    List<Integer> new_l = new ArrayList<>(l);
                    new_l.add(j,num[i]);
                    new_ans.add(new_l);
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}
