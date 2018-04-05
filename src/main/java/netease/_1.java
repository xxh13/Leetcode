package netease;

import java.util.Scanner;

public class _1 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        solve(line);
    }

    public static int solve(String s) {
        char[] chars = s.toCharArray();
        boolean[] hasChar = new boolean[26];

        int diffChar = 1;
        hasChar[chars[0] - 'A'] = true;
        for (int i = 1; i < chars.length; i++) {
            if (!hasChar[chars[i] - 'A'] && chars[0] != chars[i]) {
                hasChar[chars[i] - 'A'] = true;
                diffChar++;
            }
        }
        //if all char is the same
        if (diffChar == 1) return 1;

        //if diff char is bigger than 3
        if (diffChar > 3) return 0;

        return 2;
    }
}
