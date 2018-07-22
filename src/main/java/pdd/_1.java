package pdd;

import java.util.Scanner;

public class _1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        solution(n);
    }

    private static void solution(long n) {
        long round = 1;
        long sum = 0;

        while (sum < n) {
            sum += Math.pow(2, round + 1);
            round++;
        }

        long remain = (long) (n - (sum - Math.pow(2, round)));
        if (Math.pow(2, round - 2) >= remain) System.out.println("Alice");
        else if (Math.pow(2, round - 2) * 2 >= remain) System.out.println("Bob");
        else if (Math.pow(2, round - 2) * 3 >= remain) System.out.println("Cathy");
        else System.out.println("Dave");
    }
}
