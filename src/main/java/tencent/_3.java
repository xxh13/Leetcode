package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class _3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for (int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			for (int j = 0; j < n; j++) {
				nums[j] = scanner.nextInt();
			}
			solve(nums);
		}
	}

	private static void solve(int[] nums) {
		int count = 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] > nums[k]) {
						count++;
					} else {
						break;
					}
				}
			}
		}
		System.out.println(count);
	}
}
