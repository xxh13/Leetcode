package tujia;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _2 {
	private static int count = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int sum = scanner.nextInt();

		int[] array = new int[m];
		for (int i = 0; i < m; i++) {
			array[i] = scanner.nextInt();
		}

		solve(array, new HashSet<>(), sum);

		System.out.println(count);
	}

	private static void solve(int[] array, Set<Integer> indexes, int sum) {
		if (sum < 0) {
			return;
		}
		if (sum == 0) {
			count++;
			return;
		}

		for (int i = indexes.stream().reduce(0, (e1, e2) -> e1 > e2 ? e1 : e2); i < array.length; i++) {
			if (!indexes.contains(i)) {
				indexes.add(i);
				solve(array, indexes, sum - array[i]);
				indexes.remove(i);
			}
		}

	}
}
