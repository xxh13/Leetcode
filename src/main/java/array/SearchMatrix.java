package array;

/**
 *  num : 74
 *  Write an efficient algorithm that searches for a value in an m x n matrix.
 *  This matrix has the following properties:
 *
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 * Created by XXH on 2016/8/20.
 */
public class SearchMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2},
        };
        System.out.println(searchMatrix(matrix, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;   //the length of matrix
        int n = matrix[0].length; //the length of matrix item

        if(target < matrix[0][0] || target > matrix[m-1][n-1]) return false;

        int left = 0, right = m * n - 1,
                mid = (left + right) / 2, midVal;
        while(left + 1 != right){
            midVal = matrix[mid / n][mid % n];
            if (midVal == target) return true;
            else if (midVal < target) {
                left = mid;
                mid = (left + right) / 2;
            }
            else {
                right = mid;
                mid = (left + right) / 2;
            }
        }

        return matrix[left / n][left % n] == target || matrix[right / n][right % n] == target;
    }
}
