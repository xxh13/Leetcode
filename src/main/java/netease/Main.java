package netease;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int count = 0;
        for(int y = k + 1; y <= n; y++) {
            int a = n / y;
            count += (y - k) * a;
            if (n % y >= k)
                count += ((n % y - k + 1));

        }

        System.out.print(count);
    }
}