package leetcode_01_20;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Created by XXH on 2017/1/29.
 */
public class _20 {
    public static void main(String[] args) {
        String s = "{{()[][({{{{{}}}}})]{}}}";
        _20 demo = new _20();
        System.out.println(demo.isValid(s));
    }

    public boolean isValid(String s) {
        char[] array = s.toCharArray();

        Stack stack = new Stack();

        for (char c : array) {
            if (isLeftParentheses(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c2 = (char) stack.pop();
                    if (!isValidParentheses(c2, c)) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftParentheses(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private boolean isValidParentheses(char c1, char c2) {
        if (c1 == '(') return c2 == ')';
        else if (c1 == '[') return c2 == ']';
        else return c2 == '}';
    }
}
