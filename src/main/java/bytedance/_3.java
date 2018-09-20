package bytedance;

import java.util.Scanner;

public class _3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		scanner.nextLine();
		String[] words = scanner.nextLine().split(" ");
		String[] lines = new String[n];
		for (int i = 0; i < n; i++) {
			lines[i] = scanner.nextLine();
		}

		char[][] maps = new char[n][m];

		for (int i = 0; i < n; i++) {
			String[] temp = lines[i].split(" ");
			for (int j = 0; j < m; j++) {
				maps[i][j] = temp[j].charAt(0);
			}
		}

		find(maps, words);
	}

	private static void find(char[][] maps, String[] words) {
		for (String word : words) {
			boolean find = false;
			for (int i = 0; i < maps.length; i++) {
				for (int j = 0; j < maps[0].length; j++) {
					if (maps[i][j] == word.charAt(0)) {
						int[][] visited = new int[maps.length][maps[0].length];
						if (find(maps, i, j, visited, word, 0)) {
							System.out.println(word);
							find = true;
							break;
						}
					}
				}
				if (find) {
					break;
				}
			}
		}
	}

	private static boolean find(char[][] maps, int i, int j, int[][] visited, String target, int index) {
		if (index == target.length()) {
			return true;
		}
		if (i < 0 || i >= maps.length || j < 0 || j >= maps[0].length || visited[i][j] == 1) {
			return false;
		}
		visited[i][j] = 1;

		if (target.charAt(index) != maps[i][j]) {
			return false;
		}

		index++;

		//right
		if (find(maps, i + 1, j, visited, target, index)) {
			return true;
		}
		//down

		if (find(maps, i, j + 1, visited, target, index)) {
			return true;
		}
		//left
		if (find(maps, i - 1, j, visited, target, index)) {
			return true;
		}

		//up
		if (find(maps, i, j - 1, visited, target, index)) {
			return true;
		}

		visited[i][j] = 0;

		return false;
	}
}
