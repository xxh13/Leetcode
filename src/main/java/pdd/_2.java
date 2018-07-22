package pdd;

import java.util.Scanner;

public class _2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] lines = new String[m];
        for (int i = 0; i < m; i++) {
            lines[i] = scanner.next();
        }
        solution(lines);
    }

    private static void solution(String[] lines) {
        int m = lines.length;
        int n = lines[0].length();

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (lines[k].charAt(i) > lines[k].charAt(j)) {
                        array[j][i]++;
                    }
                    else {
                        array[i][j]++;
                    }
                }
            }
        }

        boolean isStar = true;
        for (int i = 0; i < n; i++) {
            isStar = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    isStar = true;
                } else {
                    isStar = array[i][j] > m / 2 && isStar;
                }
            }
            if (isStar) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);

    }
}
