package array;

import java.util.stream.IntStream;

/**
 *
 * Created by XXH on 2016/8/15.
 */
public class ArrayMerge {

    public static void main(String args[]) {
        int[] nums1 = new int[100];
        for (int i = 0; i < 50 ; i++) {
            nums1[i] = i * 2 - 1;
        }

        int[] nums2 = {-3, 3, 7, 10};

        ArrayMerge am = new ArrayMerge();
        am.merge(nums1, 4, nums2, 4);
        IntStream.of(nums1).forEach(e -> System.out.print(e + " "));
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++){
            int j;
            for (j = m + i - 1; j >= 0 && nums1[j] > nums2[i]; j--) {
                nums1[j + 1] = nums1[j];
            }
            if (j == m + i - 1) {
                System.arraycopy(nums2, i, nums1, m + i, n - i);
                break;
            }
            nums1[j + 1] = nums2[i];
        }

    }
}
