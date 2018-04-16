package tencent;

import java.util.Scanner;

/**
 * 寻找最长的回文子串
 */

public class Palindrome {

    public static void main(String[] args) {

    }

    private char[] reverseString(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }

    private int maxSubPalindrome(char[] array1, char[] array2) {
        int[][] subPalindrome = new int[array1.length][array2.length];
        for (int i = 0; i < subPalindrome.length; i++) {
            for (int j = 0; j < subPalindrome[0].length; j++) {
                if (i == 0 && j == 0) {
                    subPalindrome[i][j] = array1[i] == array2[j] ? 1 : 0;
                }
                if (i == 0 || j == 0) {
                    if (array1[i] == array2[j]) {
                        subPalindrome[i][j] = 1;
                    } else {
                        subPalindrome[i][j] = i == 0 ? subPalindrome[i][j - 1] : subPalindrome[j][i - 1];
                    }
                }
                else {
                    if (array1[i] == array2[j]) {
                        subPalindrome[i][j] = subPalindrome[i - 1][j - 1] + 1;
                    } else {
                        subPalindrome[i][j] = Integer.max(subPalindrome[i - 1][ j],
                                subPalindrome[i][j - 1]);
                    }
                }
            }
        }
        return subPalindrome[array1.length - 1][array2.length - 1];
    }
}
