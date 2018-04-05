package Online;

import java.util.*;

public class Online {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(solve1(array, k));
    }


    public static int solve1(int[] array, int k) {
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length - 1;) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] - array[i] == k) {
                    count++;
                    break;
                }
            }
            do {
                i++;
            } while (i < array.length - 1);
        }
        return count;
    }
}
