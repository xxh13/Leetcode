package netease;

import java.util.Scanner;

public class _4 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }
        int[] result = solve(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i != result.length - 1)
                System.out.print(" ");

        }
    }

    public static int[] solve(int[] array) {
        int[] result = new int[array.length];

        int j = 0;
        for (int i = array.length - 1; i >= 0; i-=2, j++) {
            result[j] = array[i];
        }

        for (int i = array.length % 2 == 1 ? 1 : 0; i < array.length; i+=2,j++) {
            result[j] = array[i];
        }

        return result;
    }
}
