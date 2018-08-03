package leetcode_170_200;

import org.junit.Test;

import java.util.stream.IntStream;

public class HeapTest {

    @Test
    public void insert() {
        Heap<Integer> heap = new Heap<>();
        int[] array = {10, 8, 9, 4, 3, 1, 6, 0};
        IntStream.of(array).forEach(heap::addElement);
        heap.toList().forEach(System.out::println);

        for (int i = 0; i < heap.getSize();) {
            heap.deleteElement(0);
            heap.toList().forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }
}
