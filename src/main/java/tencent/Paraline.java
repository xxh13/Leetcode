package tencent;

import java.util.Scanner;

public class Paraline {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line.length() - solve(line.toCharArray()));
        }
    }

    public static int solve(char[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            int l = i, r = array.length - 1;
            int tempMax = 0;
            while (l < r) {
                if (array[l] == array[r]) {
                    tempMax += 2;
                    l++;
                    r--;
                } else {
                    r--;
                }
            }
            if (l == r) {
                tempMax ++;
            }
            max = tempMax > max ? tempMax : max;
        }

        return array.length - max;
    }
}
