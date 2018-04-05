package netease;

import java.util.Scanner;

public class _3 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(solve(line));
    }

    public static int solve(String s) {
        char[] chars = s.toCharArray();
        int max = 1, len = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                len++;
            } else {
                max = max < len ? len : max;
                len = 1;
            }
        }
        max = max < len ? len : max;
        return max;
    }

}
