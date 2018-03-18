package Online;

import java.util.LinkedList;
import java.util.List;

public class MinStack<T extends Comparable<T>> {
    private List<T> stack = new LinkedList<>();
    private List<T> minStack = new LinkedList<>();

    private void push(T x) {
        stack.add(x);
        if (minStack.get(minStack.size() - 1).compareTo(x) > 0) {
            minStack.add(x);
        }
    }

    private T pop() throws Exception {
        if (stack.isEmpty()) throw new Exception("empty stack");
        T ele = stack.remove(stack.size() - 1);
        T min = minStack.get(stack.size() - 1);
        if (ele.compareTo(min) == 0) {
            minStack.remove(minStack.size() - 1);
        }

        return ele;
    }

    private T top() throws Exception {
        if (stack.isEmpty()) throw new Exception("empty stack");
        return stack.get(stack.size() - 1);
    }

    private T getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
