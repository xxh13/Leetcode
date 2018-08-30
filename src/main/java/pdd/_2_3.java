package pdd;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _2_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();

		solution(b, a);
	}


	private static void solution(int a, int b) {
		if (b % a == 0) {
			System.out.println("0 0");
			return;
		}
		Set<Integer> set = new HashSet<>();

		int count = 0;
		while (b % a != 0) {
			if (set.add(b % a)) {
				b = (b % a) * 10;
				count++;
			} else {
				break;
			}
		}

		if (b % a == 0) {
			System.out.println(count + " 0");
			return;
		}
		System.out.println(count - 1 + " " + set.size());
	}
}
