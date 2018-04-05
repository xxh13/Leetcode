package offer;

public class _6 {

    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length - 1, mid = 0;

        while (left != right - 1) {
            mid = (left + right) /2;
            if (array[mid] < array[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return array[right];
    }
}
