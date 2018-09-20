package tencent;

import java.util.Scanner;

public class _1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();

		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = scanner.nextInt();
		}
		int k = scanner.nextInt();


	}

	private void solve(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

	}
}
