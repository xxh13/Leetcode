package huawei;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Main1 main = new Main1();
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int result = main.getCommon(s1, s2);

        System.out.println(result);
    }

    private int getCommon(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        if (array1.length == 0 || array2.length == 0) {
            return 0;
        }

        int[][] dp = new int[array1.length + 1][array2.length + 1];

        for (int i = 0; i <= array1.length; i++) {
            for (int j = 0; j <= array2.length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        int max = dp[array1.length][array2.length];
        if (max == 0) {
            return 0;
        }


        return 0;
    }
}
