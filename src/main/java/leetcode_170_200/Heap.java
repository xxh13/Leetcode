package leetcode_170_200;

import java.util.ArrayList;
import java.util.List;

/**
 * min heap (child > parent)
 * heap implement
 * @param <E>
 */
public class Heap<E extends Comparable> {

    private List<E> elements;
    private int capacity;
    private int size;

    public Heap() {
        this(Integer.MAX_VALUE);
    }

    public Heap (int capacity) {
        this.elements = new ArrayList<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean addElement(E e) {
        if (elements.size() < capacity) {
            elements.add(e);
            size++;
        }
        filterUp(size - 1);

        return true;
    }

    public int getSize() {
        return this.size;
    }

    public E deleteElement(int index) {
        E element = elements.get(index);
        elements.set(index, elements.get(size - 1));
        elements.remove(size - 1);
        size--;

        filterDown(index);
        return element;
    }

    private void filterUp(int index) {
        int i = index;
        E exchange = elements.get(index);

        int parentIndex = (i - 1) / 2;
        while (elements.get(parentIndex).compareTo(exchange) > 0 && i != 0) {
            elements.set(i, elements.get(parentIndex));
            i = parentIndex;
            parentIndex = (i - 1) /2;
        }

        elements.set(i, exchange);
    }

    private void filterDown(int index) {
        int parentIndex = index;
        E parent = elements.get(index);

        int leftChildIndex = 2 * parentIndex + 1;

        int temp = 0;
        while (leftChildIndex < elements.size()) {
            E child;
            E leftChild = elements.get(leftChildIndex);
            E rightChild = elements.get(leftChildIndex + 1 >= size ? leftChildIndex : leftChildIndex + 1);
            if (leftChild.compareTo(rightChild) <= 0) {
                temp = leftChildIndex;
                child = leftChild;
            } else  {
                temp = leftChildIndex + 1;
                child = rightChild;
            }
            if (child.compareTo(parent) < 0) {
                elements.set(parentIndex, child);
                parentIndex = temp;
                leftChildIndex = parentIndex * 2 + 1;
            } else {
                break;
            }
        }

        elements.set( (leftChildIndex - 1) / 2, parent);
    }

    public List<E> toList() {
        return this.elements;
    }
}
