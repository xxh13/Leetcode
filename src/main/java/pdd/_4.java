package pdd;

import java.util.Scanner;

public class _4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String phone = scanner.next();
        solution(n, k, phone);
    }

    private static void solution(int n, int k, String phone) {
        if (isValid(k, phone)) {
            System.out.println(0 + " " + phone);
            return;
        }

        //找出所有出现过的数字

    }

    private static boolean isValid(int k, String phone) {
        char[] chars = phone.toCharArray();
        char[] validChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int[] count = new int[10];
        for (int i = 0; i < chars.length; i++) {
            for (char c : validChars) {
                if (chars[i] == c) {
                    count[c - '0']++;
                    if (count[c - '0'] >= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
