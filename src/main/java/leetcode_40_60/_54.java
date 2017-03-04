package leetcode_40_60;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * Created by john on 2017/3/4.
 */
public class _54 {

    public static void main(String[] args) {
        _54 demo = new _54();
        int[][] matrix = {};
        demo.spiralOrder(matrix).forEach(e->System.out.print(e + " "));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrder = new LinkedList<>();
        if (matrix.length == 0)
            return spiralOrder;

        int width = matrix[0].length, height = matrix.length, num = width * height;
        int size = spiralOrder.size();
        int i = 0;
        while (size < num) {
            int j = i;
            //add the first line
            while (j < width - i) {
                spiralOrder.add(matrix[i][j]);
                j++;
            }
            //add the first column
            j = i + 1;
            while (j < height - i) {
                spiralOrder.add(matrix[j][width - 1 - i]);
                j++;
            }
            //add the second line
            j = width - i - 2;
            while (height - i - 1 > i && j > i) {
                spiralOrder.add(matrix[height - 1 - i][j]);
                j--;
            }
            //add the second column
            j = height - i - 1;
            while (width - i - 1 > i && j > i) {
                spiralOrder.add(matrix[j][i]);
                j--;
            }
            size = spiralOrder.size();
            i++;
        }

        return spiralOrder;
    }
}
