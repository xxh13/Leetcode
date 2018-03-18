package leetcode_120_140;

import java.util.List;

public class _139 {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<String> list = List.of("leet", "code");
        String s = "leetcode";
        _139 demo = new _139();

        System.out.println(demo.wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            if (wordDict.contains(s.substring(0, i))) {
                dp[i] = true;
            }
            else {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
        }

        return dp[dp.length - 1];
    }
}
