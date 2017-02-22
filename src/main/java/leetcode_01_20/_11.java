package leetcode_01_20;

/**
 * Container With Most Water
 * Created by XXH on 2017/1/15.
 */
public class _11 {

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = max(maxArea, (right-left)*min(height[left], height[right]));
            if (height[right] > height[left]) left++;
            else right--;
        }

        return maxArea;
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }
}
