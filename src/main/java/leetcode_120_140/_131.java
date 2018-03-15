package leetcode_120_140;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _131 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        _131 demo = new _131();
        String s = "bcbcbc";
        List<List<String>> partitions = demo.partition(s);
        System.out.println();
    }

    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new LinkedList<>();
        List<String> partition = new LinkedList<>();
        partition(partitions, partition, s.toCharArray(), 0, s.length() - 1);

        return partitions;
    }

    private void partition(List<List<String>> partitions, List<String> partition, char[] array, int start, int end) {
        for (int i = start; i <= end;) {
            if (isPalindrome(array, start, i)) {
                partition.add(new String(array, start, i - start + 1));
                partition(partitions, partition, array, i + 1, end);
                partition.remove(partition.size() - 1);
            }
            i++;

        }
        if (start > end)
            partitions.add(new ArrayList<>(partition));

    }

    private boolean isPalindrome(char[] array, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            if (array[i] != array[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}
