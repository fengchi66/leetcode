package code.class20;


/**
 * 最长回文子序列的长度
 */
public class Code01_PalindromeSubsequence {

    public static int lpsl(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] str = s.toCharArray();

        return process(str, 0, str.length - 1);
    }

    // str[L...R]上，返回最长回文子序列长度返回
    // 范围尝试模型，特别强调边界问题，也就是开头如何，结尾如何(可能性)
    public static int process(char[] str, int L, int R) {
        // base case
        // 自己和自己肯定是回文，返回1
        if (L == R)
            return 1;
        // 只有两个字符,如果相等就返回2，不是就返回1
        if (L == R - 1)
            return str[L] == str[R] ? 2 : 1;
        /**
         * 普遍情况,str[L...R]上最长回文子序列的可能性
         * 1. 最长回文既不以为L开头，也不以R结尾
         * 2. 最长回文以L开头，但不以R结尾
         * 3. 最长回文不以L开头，但以R结尾
         * 4. 既以L开头，也以R结尾
         */
        int p1 = process(str, L + 1, R - 1);
        int p2 = process(str, L + 1, R);
        int p3 = process(str, L, R - 1);
        int p4 = str[L] == str[R] ? 2 + process(str, L + 1, R - 1) : 0;

        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    // 动态规划
    public static int lpsl2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] str = s.toCharArray();
        int N = str.length;
        // dp表: L:[0...N-1] R:[0...N-1]
        int[][] dp = new int[N][N];
        // 先把dp[N-1][N-1]位置填了,后面dp[i][i + 1]就可以直接填
        dp[N - 1][N - 1] = 1;

        // 填两条对角线
        for (int i = 0; i < N - 1; i++) {
            dp[i][i] = 1;
            dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
        }

        // 从下到上对角线开始填
        for (int L = N - 3; L >= 0; L--) {
            for (int R = L + 2; R < N; R++) {
                dp[L][R] = Math.max(dp[L][R - 1], dp[L + 1][R]);
                if (str[L] == str[R]) {
                    // 空间感优化
                    dp[L][R] = Math.max(dp[L][R], 2 + dp[L + 1][R - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }

    public static void main(String[] args) {
        String str = "abcdfehcba";
        System.out.println(lpsl(str));
    }

}
