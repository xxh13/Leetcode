package leetcode_60_80;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2
 * You have the following 3 operations permitted on a word:
     a) Insert a character
     b) Delete a character
     c) Replace a character
 * Created by john on 2017/3/12.
 */
public class _72 {

    public static void main(String[] args) {

    }

    /**
     * https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();

        if (m == 0) return n;
        if (n == 0) return m;
        char[] word1_array = word1.toCharArray(), word2_array = word2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
                if (i != 0 && j != 0) {
                    if (word1_array[i - 1] == word2_array[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = minOfThree(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }

        return dp[m][n];
    }
    private int minOfThree(int a, int b, int c) {
        if (a > b) {
            return c < b ? c : b;
        } else {
            return c < a ? c : a;
        }
    }
}
