package netease;

import java.util.Arrays;
import java.util.Scanner;

public class _2 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        solve(array);
    }

    public static String solve(int[] array) {
        if (array.length <= 2) return "possible";
        Arrays.sort(array);
        int gap = array[1] - array[0];

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i + 1] - array[i] != gap)
                return "impossible";
        }

        return "possible";
    }
}
