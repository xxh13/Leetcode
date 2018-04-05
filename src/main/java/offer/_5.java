package offer;

import java.util.Stack;

public class _5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    boolean push = true;

    public void push(int node) {
        if (push) {
            stack1.push(node);
        } else {
            while(! stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(node);
        }
        push = true;
    }

    public int pop() {
        int result;
        if (!push) {
            result = stack2.pop();
        } else {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            result = stack2.pop();
        }
        push = false;
        return result;
    }
}
