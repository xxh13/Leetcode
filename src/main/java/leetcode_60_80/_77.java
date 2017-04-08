package leetcode_60_80;

import java.util.List;
import java.util.LinkedList;

public class _77 {
    public static void main(String[] args){
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        _77 demo = new _77();
        demo.combine(n, k).forEach(System.out::println);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new LinkedList<>();
        List<Integer> combination = new LinkedList<>();
        combine(combinations, combination, 1, 0, n, k);
        return combinations;
    }

    private void combine(List<List<Integer>> combinations, List<Integer> combination, int start, int count, int n, int k)
    {
        if (count == k) {
            combinations.add(new LinkedList<>(combination));
            return;
        }
        for (int i = start; i <= n; i++) {
            combination.add(i);
            count++;
            combine(combinations, combination, i + 1, count, n, k);
            count--;
            combination.remove(combination.size() - 1);
        }
    }
}
