package leetcode_40_60;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * Created by john on 2017/2/23.
 */
public class _42 {

    public static void main(String[] args) {
        _42 demo = new _42();
        int[] height = {4,2,1,2,5};
        System.out.println(demo.trap(height));
    }

    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int unit = 0;

        int left_side = 0, right_side = 0;

        while (right_side < height.length) {
            //get the right side of container
            while (left_side < height.length - 1 && height[left_side] <= height[left_side + 1])
                left_side++;

            //get the lowest_height of container
            int index = left_side;
            while (index < height.length - 1 && height[index] >= height[index + 1])
                index++;


            if (index == height.length - 1) break;

            right_side = index + 1;

            //get the right side of the container
            while (right_side < height.length) {
                if (height[right_side] >= height[left_side]) {
                    index = right_side;
                    break;
                } else {
                    if (height[right_side] > height[index]) {
                        index = right_side;
                    }
                    right_side++;
                }
            }

            right_side = index;
            //calculate
            int v = Math.min(height[left_side], height[right_side]) * (right_side - left_side + 1);
            for (int i = left_side + 1; i < right_side; i++) {
                v -= height[i] <= Math.min(height[left_side], height[right_side])
                                ? height[i] : Math.min(height[left_side], height[right_side]);
            }
            v -= 2 * Math.min(height[left_side], height[right_side]);
            unit += v;


            left_side = right_side;
        }

        return unit;

    }
}
