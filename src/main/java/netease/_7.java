package netease;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _7 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(solve(array));
    }

    private static int solve(int[] array) {
        int max = 0;

        Arrays.sort(array);

        List<Integer> list = new ArrayList<>();

        int i = 0, j = array.length - 1;

        while (i < j) {
            list.add(array[i++]);
            if (i < j) {
                list.add(array[j--]);
            }
        }

        if (Math.abs(list.get(0) - array[i]) < Math.abs(list.get(list.size() - 1) - array[i])) {
            list.add(array[i]);
        } else {
            list.add(0, array[i]);
        }

        for (int n = 0; n < list.size() - 1; n++) {
            max += Math.abs(list.get(n + 1) - list.get(n));
        }

        return max;
    }
}
