package leetcode_100_120;

import java.util.ArrayList;
import java.util.List;

public class _118 {
    public static void main(String[] args) {
        _118 demo = new _118();
        demo.getRow(32).forEach(System.out::println);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangles = new ArrayList<>();
        if (numRows == 0) return triangles;
        if (numRows > 0) {
            List<Integer> first = new ArrayList<>();
            first.add(1);
            triangles.add(first);
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> preTriangle = triangles.get(i - 1);
            int size = preTriangle.size();
            List<Integer> triangle = new ArrayList<>();
            triangle.add(1);
            for (int j = 0; j < size - 1; j++) {
                triangle.add(preTriangle.get(j) + preTriangle.get(j + 1));
            }
            triangle.add(1);
            triangles.add(triangle);
        }

        return triangles;
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }


}
