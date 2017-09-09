package leetcode_80_100;

import java.util.Stack;

public class _84 {


    public static void main(String[] args) {
        _84 demo = new _84();
        int[] array = {2,1,2};
        System.out.println(demo.largestRectangleArea3(array));
    }

    /**
     * o(n^2)
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int minHeight;
        int area = 0;
        int length = heights.length;

        for (int i = 0; i < length; i++) {
            minHeight = heights[i];
            for (int j = i; j < length; j++) {
                minHeight = min(heights[j], minHeight);
                if (area < minHeight * (j - i + 1)) {
                    area = (j - i + 1) * minHeight;
                }
            }
        }

        return area;
    }

    private int min(int x1, int x2) {
        return x1 > x2 ? x2 : x1;
    }

    private int max(int x1, int x2) {
        return x1 > x2 ? x1 : x2;
    }

    public int largestRectangleArea2(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    /**
     * divide and conquer
     * @param heights
     * @param left : include
     * @param right : include
     * @return
     */
    private int largestRectangleArea(int[] heights, int left, int right) {
        if (left == right)
            return heights[left];
        int middle = (left + right) / 2;
        int leftMaxArea = largestRectangleArea(heights, left, middle);
        int rightMaxArea = largestRectangleArea(heights, middle + 1, right);

        //calculate combine area
        int i = middle, j = middle + 1;
        int area = 0, h = min(heights[i], heights[j]);
        while (i >= left && j <= right) {
            h = minOfThree(h, heights[i], heights[j]);
            area = max(area, (j - i + 1) * h);
            if (i == left) {
                j++;
            } else if (j == right) {
                i--;
            } else {
                if (heights[i - 1] > heights[j + 1]) {
                    i--;
                } else {
                    j++;
                }
            }
        }

        return maxOfThree(leftMaxArea, area, rightMaxArea);
    }

    /**
     * o(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int area = 0;
        for (int i = 0; i < heights.length;) {
            if (s.empty() || heights[s.peek()] <= heights[i]) {
                s.push(i);
                i++;
            }
            else {
                int tp = s.pop();
                area = heights[tp] * (s.empty() ? i : i - s.peek() - 1);
                maxArea =  maxArea > area ? maxArea : area;
            }
        }

        while (!s.empty()){
            int tp = s.pop();
            area = heights[tp] * (s.empty() ? heights.length : heights.length - s.peek() - 1);
            maxArea =  maxArea > area ? maxArea : area;
        }

        return maxArea;
    }

    private int minOfThree(int x, int y, int z) {
        if (x > y) {
            return y > z ? z : y;
        } else {
            return x > z ? z : x;
        }
    }

    private int maxOfThree(int x, int y, int z) {
        if (x > y) {
            return x > z ? x : z;
        } else {
            return y > z ? y : z;
        }
    }
}
