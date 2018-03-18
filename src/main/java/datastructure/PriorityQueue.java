package datastructure;

public class PriorityQueue{
    int[] queue = new int[16];
    int size = 0;

    /**
     * 向最小堆中插入一个元素
     * @param x :
     * @return
     */
    public boolean offer(int x) {
        if (size == 0) {
            queue[0] = x;
        } else {
            queue[size] = x;
            shiftUp(size, x);
            size++;
        }
        return true;
    }


    public int peek() throws Exception{
        if (size == 0) throw new Exception("empty queue");
        return queue[0];
    }

    public int poll() throws Exception{
        if (size == 0) throw new Exception("empty queue");
        int i = size - 1;
        int ele = queue[0];
        queue[0] = queue[i];
        shiftDown(0, ele);
        size--;
        return ele;
    }


    /**
     * 从最小堆中删除一个元素
     * @param x
     * @return
     * @throws Exception
     */
    public boolean remove(int x) throws Exception {
        int i = indexOf(x);
        if (i == -1) return false;

        // if i is the last ele
        if (i == size - 1) {
            queue[i] = 0;
            size--;
            return true;
        }

        queue[i] = queue[size - 1];
        shiftDown(i, x);
        size--;
        return true;
    }

    public int indexOf(int x) throws Exception {
        for (int i = 0; i < size; i++) {
            if (queue[i] == x) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 堆数组进行扩容
     */
    public void grow() {
        int[] newQueue = new int[queue.length * 2];
        System.arraycopy(newQueue, 0, queue, 0, queue.length);
        queue = newQueue;
    }


    /**
     * 最小堆上浮的操作
     * @param index： 上浮开始的下标
     * @param x ： 上浮的元素
     */
    public void shiftUp(int index, int x) {
        int i = index;

        while (i > 0) {
            int j = (i - 1) / 2;
            int parent = queue[j];
            if (parent < x) break;
            queue[j] = parent;
            i = j;
        }

        queue[i] = x;
    }


    /**
     * 最小堆下沉操作
     * @param index：下沉开始的下表
     * @param x ： 下沉的元素
     */
    public void shiftDown(int index, int x) {
        int i = index;

        int half = size / 2;

        while (i < half) {
            int leftChild = i * 2 + 1;
            int rightChild = i * 2 + 2;
            int swapChild = leftChild;
            if (rightChild <= size) {
                swapChild = queue[leftChild] < queue[rightChild] ? leftChild : rightChild;
            }
            if (queue[swapChild] > x) break;
            queue[i] = queue[swapChild];
            i = swapChild;
        }

        queue[i] = x;
    }
}
