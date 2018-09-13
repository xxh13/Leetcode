package tujia;

import java.util.Scanner;

public class _1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		solve(m, n);
	}

	private static void solve(int m, int n) {
		int m1 = m, n1 = n;

		if (m1 < n1) {
			int temp = m1;
			m1 = n1;
			n1 = temp;
		}
		while (m1 % n1 != 0) {
			int temp = m1 % n1;
			m1 = n1;
			n1 = temp;
		}
		System.out.println(n1);
		System.out.println(m * n / n1);
	}

}
