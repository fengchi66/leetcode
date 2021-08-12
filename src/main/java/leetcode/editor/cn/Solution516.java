package leetcode.editor.cn;

public class Solution516 {
    // 最长回文子串
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int N = s.length();
        // dp[i...j]表示s[i...j]的最长回文子串的长度
        int[][] dp = new int[N][N];

        // base case
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }


}
