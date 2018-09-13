package tujia;

import java.util.Scanner;

public class _3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		scanner.nextLine();
		String[] array = new String[length];

		for (int i = 0; i < length; i++) {
			array[i] = scanner.nextLine();
		}
		solve(array);
	}


	private static void solve(String[] lines) {
		for (String line : lines) {
			String[] elements = line.split(" ");
			if (winOrLose(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])) == 0) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
		}
	}

	private static int winOrLose(int n ,int k) {
		if(n % (k + 1) == 0) return 0;
		else return 1;
	}
}
