package leetcode_120_140;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 */
public class _150 {

    public static void main(String[] args) {

    }



    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(eval(token, a, b));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }

        return false;
    }

    private int eval(String operator, int a, int b) {
        if (operator.equals("+")) {
            return a + b;
        }
        else if (operator.equals("-")) {
            return a - b;
        }
        else if (operator.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}
