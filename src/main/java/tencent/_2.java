package tencent;

import java.util.Scanner;

public class _2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int[][] array1 = new int[m][2];
		for (int i = 0; i < m; i++) {
			array1[i][0] = scanner.nextInt();
			array1[i][1] = scanner.nextInt();
		}

		int[][] array2 = new int[n][2];
		for (int i = 0; i < n; i++) {
			array2[i][0] = scanner.nextInt();
			array2[i][1] = scanner.nextInt();
		}

		solve(array1, array2);
	}


	public static void solve(int[][] array1, int[][] array2) {
		for (int i = 0; i < array2.length; i++) {
			int steps = 0;
			for (int j = 0; j < array1.length; j++) {
				steps += (Math.abs(array1[j][0] - array2[i][0]) + Math.abs(array1[j][1] - array2[i][1]));
			}
			System.out.println(steps);
		}
	}
}
