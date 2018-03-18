package datastructure;
import java.util.PriorityQueue;

// fix size priority queue, for top
public class FixSizedPriorityQueue<E extends Comparable<E>> {

    private PriorityQueue<E> queue;
    private int maxSize;

    //最小堆 模拟topN大
    public FixSizedPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new PriorityQueue<>(maxSize, (e1, e2) -> e1.compareTo(e2));
    }

    public boolean add (E x) {
        if (queue.size() < maxSize) {
            queue.add(x);
        } else {
            E e = queue.peek();
            if (e.compareTo(x) < 0) {
                queue.poll();
                queue.add(x);
            }
            else {
                return false;
            }
        }

        return true;
    }
}
