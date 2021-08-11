package code.class19;


/**
 * 最长公共子序列
 */
public class Code04_LongestCommonSubsequence {

    public int longestCommonSubsequence1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return 0;

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        // 暴力递归
        return process1(str1, str2, str1.length - 1, str2.length - 1);
    }

    // str1[0...i]与str2[0...j]最长公共子序列长度
    public static int process1(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) // i和j都为0
            return str1[i] == str2[j] ? 1 : 0;
        else if (i == 0) { // i == 0 且j != 0
            return str1[i] == str1[j] ? 1 : process1(str1, str2, i, j - 1);
        } else if (j == 0) { // j == 0 且i != 0
            return str1[i] == str1[j] ? 1 : process1(str1, str2, i - 1, j);
        } else { // i != 0 且j != 0
            // 公共子序列以str1结尾
            int p1 = process1(str1, str2, i - 1, j);
            // 以str2结尾
            int p2 = process1(str1, str2, i, j - 1);
            // 既以str1结尾也以str2结尾
            int p3 = str1[i] == str2[j] ? 1 + process1(str1, str2, i - 1, j - 1) : 0;

            return Math.max(p1, Math.max(p2, p3));
        }
    }

    public int longestCommonSubsequence2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
            return 0;

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int N = s1.length();
        int M = s2.length();

        // dp表
        int[][] dp = new int[N][M];
        // 第0行第0列
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;

        // i == 0 且j != 0
        for (int j = 1; j < M; j++) {
            dp[0][j] = str1[0] == str2[j] ? 1 : dp[0][j - 1];
        }
        // j == 0 且i != 0
        for (int i = 1; i < N; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }
        // i != 0 且j != 0
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(p1, Math.max(p2, p3));
            }
        }

        return dp[N - 1][M - 1];
    }


}
