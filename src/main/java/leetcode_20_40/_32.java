package leetcode_20_40;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * Created by john on 2017/2/20.
 */
public class _32 {

    public static void main(String[] args) {
        _32 demo = new _32();
        String s = "(()()(())((";
        System.out.println(demo.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int longestLength = 0;
        char[] array = s.toCharArray();

        int start = 0;
        while (start < array.length && array[start] == ')') start++;

        Stack<Integer> stack = new Stack<>();
        int[] indexArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            indexArray[i] = -1;
        }

        int count;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                stack.push(i);
            } else {
                if (!stack.empty()) {
                    int leftIndex =  stack.pop();
                    indexArray[i] = leftIndex;
                    count = i - leftIndex + 1;
                    while (leftIndex > 0 && indexArray[leftIndex - 1] != -1) {
                        count += (leftIndex - indexArray[leftIndex - 1]);
                        leftIndex = indexArray[leftIndex-1];
                    }

                    if (count >= longestLength) {
                        longestLength = count;
                    }

                } else {
                    count = 0;
                }
            }
        }

        return longestLength;
    }
}
