package sort;

import java.util.stream.IntStream;

public class InsertSort {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] array = {1, 3, 4, 8, 10, 3, 2, 5, 7};
        InsertSort is = new InsertSort();
        is.quickSort(array);
        IntStream.of(array).forEach(System.out::println);
    }


    public void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int ele = array[i];
            for (; j > 0 & ele < array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = ele;
        }
    }

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j ,j + 1);
                }
            }
        }
    }

    public void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int leftEnd = mid;
        int j = mid + 1;
        int rightEnd = right;

        int index = 0;

        while (i <= leftEnd && j <= rightEnd) {
            temp[index++] = array[i] < array[j] ? array[i++] : array[j++];
        }

        while (i <= leftEnd) {
            temp[index++] = array[i++];
        }

        while (j <= right) {
            temp[index++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }

    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        int pivo = array[left];
        int i = left, j = right;

        while (i <= j) {
            while (array[j] > pivo && j > i) j--;
            while (array[i] < pivo && i < j) i++;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        quickSort(array, left, i);
        quickSort(array, i + 1, right);
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
