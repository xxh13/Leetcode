package sample;

import java.util.stream.IntStream;

/**
 *
 * Created by XXH on 2016/4/6.
 */
public class MySort {
    public static void main(String args[]) throws Exception {
//        int[] a = new int[]{49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        int a[] = {8,4,1,2};
        IntStream.of(a).forEach(e->System.out.print(e + " "));
        System.out.println();
//        a = insertSort(a);
//        a = shellSort(a);
//        a = selectSort(a);
//        a = bubbleSort(a);
//        IntStream.of(a).forEach(e->System.out.print(e+ " "));
//        System.out.println();
        mergeSort(a);

        IntStream.of(a).forEach(e->System.out.print(e+ " "));

//        int b[] ={1,3,3};
//        median3(b, 1, 3);
    }

    public static int[] insertSort(int[] a){

        int data[] = a;
        int j = 0;
        for(int i=1;i<data.length; i++){
            int temp = data[i];
            for(j = i; j>0 && data[j] > temp; j--){
                a[j] = a[j-1];
            }
            a[j] = temp;
        }

        return data;
    }

    public static int[] shellSort(int[] a){
        int[] data = a;

        int d = data.length;
        int j = 0;
        while (d > 1){
            d = d/3;
            for(int i=d; i<data.length; i++){
                int temp = data[i];
                for(j=i; j >= d && data[j-d] > temp; j=j-d){
                    data[j] = data[j-d];
                }
                data[j] = temp;
            }
            IntStream.of(a).forEach(e->System.out.print(e+ " "));
            System.out.println();
        }
        return data;
    }

    public static int[] selectSort(int[] a){
        int[] data = a;
        int index = 0;
        int min;
        for(int i=0;i<data.length; i++){
            min = data[i];
            for(int j = i+1; j<data.length; j++){
                if(min > data[j]){
                    min = data[j];
                    index = j;
                }
            }
            int temp = data[i];
            data[i] = min;
            data[index] = temp;
        }

        return data;
    }

    public static int[] bubbleSort(int[] a){
        int[] data = a;
        for(int i=0;i<data.length;i++){
            for(int j=0; j<data.length-i-1; j++){
                if( data[j] > data[j+1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    /*
    * 快速排序
    * */
    public static int[] quick(int a[]){
        if(a.length > 0){
            quickSort1(a, 0, a.length-1);
        }

        return a;
    }

    public static void quickSort(int[] a, int left, int right){
        if(left < right) {
            int pivotPos = getMiddle(a, left, right);
            quickSort(a, left, pivotPos - 1);
            quickSort(a, pivotPos + 1, right);
        }
    }

    public static int getMiddle(int[] list, int low, int high){
        int temp = list[low];

        while (low < high){
            while (low < high && list[high] >= temp){
                high--;
            }
            list[low] = list[high];

            while (low < high && list[low] <= temp){
                low ++;
            }
            list[high] = list[low];
        }
        list[low] = temp;

        return low;
    }

    /*
    * 快速排序实现2
    * */
    public static void quickSort1(int[] a, int left, int right) {
        if (left < right) {
            int i = left + 1;
            int j = right;

            for (; ;) {
                while (a[i] < a[left] && i<right) {
                    i++;
                }
                while (a[j] > a[left] && j > left) {
                    j--;
                }
                if (i < j) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }else{
                    break;
                }

            }
            int temp = a[j];
            a[j] = a[left];
            a[left] = temp;

//            IntStream.of(a).forEach(e->System.out.print(e + " "));
//            System.out.println();
            quickSort1(a, left, j-1);
            quickSort1(a, j+1, right);
        }
    }


    /*
    * 归并排序
    * */
    private static void merge(int[] a, int[] temp, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int numElement = rightEnd - leftPos + 1;
        int tempPos = leftPos;

        while (leftPos <= leftEnd && rightPos <= rightEnd){
            if (a[leftPos] < a[rightPos]){
                temp[tempPos++] = a[leftPos++];
            }else {
                temp[tempPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd){
            temp[tempPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd){
            temp[tempPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElement; i++, rightEnd--) {
            a[rightEnd] = temp[rightEnd];
        }
    }

    private static void mergeSort(int[] a, int[] temp, int left, int right){
        if (left < right){
            int center = (left + right) / 2;
            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center+1 , right);
            merge(a, temp, left, center+1, right);
        }
    }

    public static void mergeSort(int[] a){
        int[] tempArray = new int[a.length];
        System.arraycopy(a,0,tempArray,0,a.length);
        mergeSort(a, tempArray, 0, a.length-1);
    }

}
