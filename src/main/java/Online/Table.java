package Online;

import java.util.Arrays;
import java.util.Scanner;

public class Table {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int numberOfTable = scanner.nextInt();
        int numberOfConsumer = scanner.nextInt();
        int i = 0, j = 0;
        int[] table = new int[numberOfTable];
        int[] seq = new int[numberOfConsumer];
        int[] consume = new int[numberOfConsumer];
        while (i < numberOfTable) {
            table[i] = scanner.nextInt();
            i++;
        }
        while (j < numberOfConsumer) {
            seq[j] = scanner.nextInt();
            consume[j] = scanner.nextInt();
            j++;
        }
        System.out.println(solve(table, seq, consume));
    }

    private static int solve(int[] table, int[] seq, int[] consume) {
        int result = 0;
        int[] consumed = new int[seq.length];
        Arrays.sort(table);
        for (int i = 0; i < table.length; i++) {
            int max = Integer.MIN_VALUE;
            int index = -1;
            for (int j = 0; j < seq.length; j++) {
                if (consumed[j] == 0 && seq[j] <= table[i] && max < consume[j]) {
                    max = consume[j];
                    index = j;
                }
            }
            if (index != -1) {
                consumed[index] = 1;
                result += max;
            }

        }
        return result;
    }
}
