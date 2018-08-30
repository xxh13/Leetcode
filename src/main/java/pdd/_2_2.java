package pdd;

import java.util.Scanner;

public class _2_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();

		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = scanner.nextLine();
		}

		solution(lines);
	}

	private static void solution(String[] lines) {
		int length = lines.length;
		char[][] chars = new char[lines.length][];

		for (int i = 0; i < lines.length; i++) {
			chars[i] = lines[i].toCharArray();
		}

		for (int i = length - 1; i >= 0; i--) {
			for (int j = 0; j < chars[i].length; j++) {
				if (chars[i][j] == 'o') {
					if (i == length - 1) {
						chars[i][j] = '.';
					} else {
						int index = i;
						while (index < length - 1) {
							if (chars[index + 1][j] == '.') {
								chars[index][j] = '.';
								index++;
							} else {
								chars[index][j] = 'o';
								break;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < lines.length; i++) {
			System.out.println(chars[i]);
		}
	}
}
