package netease;

import java.util.Scanner;

public class _5 {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int f = scanner.nextInt();
        int d = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(solve(x, f, d, p));
    }

    /**
     *
     * @param x: 租金
     * @param f：水果
     * @param d：钱
     * @param p：水果钱
     * @return： int
     */
    public static int solve(int x, int f, int d, int p) {

        // 如果租房的天数小于水果的个数
        if (d / x < f) return d / x;

        while (d / x > f) {
            d -= p;
            f ++;
        }

        return d / x < f - 1 ? f - 1 : d / x;
    }
}
