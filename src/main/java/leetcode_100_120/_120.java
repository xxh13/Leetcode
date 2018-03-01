package leetcode_100_120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _120 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        _120 demo = new _120();
        List<Integer> row1 = List.of(-1);
        List<Integer> row2 = List.of(3, 2);
        List<Integer> row3 = List.of(-3, 1, -1);
        List<Integer> row4 = List.of(4, 1, 8, 3);
        List<Integer> row5 = List.of(2, 4, 3, 1, 3);

        List<List<Integer>> triangle = List.of(row1, row2, row3);

        System.out.println(demo.minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        if (rows == 0) return 0;
        if (rows == 1) return triangle.get(0).get(0);
        int[] minRowPre = new  int[rows];
        int[] minRowValue = new int[rows];
        minRowPre[0] = triangle.get(0).get(0);

        for (int i = 1; i < rows; i++) {
            List<Integer> rowValue = triangle.get(i);
            for (int j = 0; j < rowValue.size(); j++) {
                int min = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    min = minRowPre[j - 1] + rowValue.get(j) < min ? minRowPre[j - 1] + rowValue.get(j) : min;
                }
                if (j < rowValue.size() - 1) {
                    min = minRowPre[j] + rowValue.get(j) < min ? minRowPre[j] + rowValue.get(j) : min;
                }
                minRowValue[j] = min;
            }
            System.arraycopy(minRowValue, 0, minRowPre, 0, rows);
        }

        return minArrayValue(minRowValue);
    }

    private int minArrayValue(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int e : array) {
            if (e < min) {
                min = e;
            }
        }

        return min;
    }
}
