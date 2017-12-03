package leetcode_80_100;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * Created by XXH on 2017/9/11.
 */
public class _97 {

    public static void main(String[] args) {
        _97 demo = new _97();
        System.out.println(demo.isInterleave("", "", ""));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                else if (i == 0) {
                    dp[i][j] = s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1];
                }
                else if (j == 0) {
                    dp[i][j] = s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j];
                } else {
                    dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) ||
                            (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

}
