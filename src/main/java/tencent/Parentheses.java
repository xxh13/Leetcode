package tencent;

import java.util.Scanner;

public class Parentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean[] result = new boolean[size];
        for (int i = 0; i < size; i++) {
            result[i] = isValid(sc.next().toCharArray());
        }
        for (int i = 0; i < size; i++) {
            if (result[i]) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean isValid(char[] parentheses) {
        int init = 0;
        for (int i = 0; i < parentheses.length; i++) {
            if (parentheses[i] == '(') {
                init++;
            } else {
                init--;
            }
            if (init < -1) {
                return false;
            }
        }
        if (parentheses.length == 2 && parentheses[0] == '(' && parentheses[1] == ')') {
            return false;
        }
        return init == 0;
    }
}
