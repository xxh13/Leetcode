package tencent;

import java.util.Scanner;

public class Main {
    static public void main(String args[]) {
        System.out.println(0.1 * 3);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];

        int[] z = new int[m];
        int[] w = new int[m];
        int[] work = new int[m];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            z[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int workRemain = m;
        int profit = 0;
        for (int i = 0; i < n; i++) {
            int time = 0, difficulty = 0, index = -1;
            for (int j = 0; j < m; j++) {
                if (x[i] >= z[j] && y[i] >= w[j] && work[j] == 0) {
                    if (z[j] >= time && w[j] >= difficulty) {
                        time = z[i];
                        difficulty = w[j];
                        index = j;
                    }
                    if ((z[j] - time) * (w[j] - difficulty) <= 0) {
                        if (time * 200 + difficulty * 3 <= z[j] * 200 + w[j] * 3) {
                            time = z[i];
                            difficulty = w[j];
                            index = j;
                        }
                    }
                }
            }
            work[index] = 1;
            profit += (z[index] * 200 + w[index] * 3);
            workRemain--;
            if (workRemain == 0) break;
        }

        System.out.print(m - workRemain);
        System.out.print(' ');
        System.out.print(profit);

    }

    public static void test(long condition) {
//        switch (condition) {
//
//        }
    }

}
