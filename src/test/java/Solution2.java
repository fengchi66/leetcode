public class Solution2 {

    /**
     * 最长回文子串
     * 递归/动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int N = s.length();

        // dp[i...j]表示在s[i...j]内是否是回文子序列
        boolean[][] dp = new boolean[N][N];

        // 最长子串开始的位置以及跨越的长度
        int start = 0;
        int step = 1;

        // base case，当i==j时，dp为true
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        // base case, 当j == i+1时，看值是不是相等
        for (int i = 0; i < N - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                start = i;
                step = 2;
            }
        }
        // 普遍情况
        for (int i = N - 3; i >= 0; i--) {
            for (int j = i + 2; j < N; j++) {
                // [i...j]是否是回文子串取决于[i+1...j-1]是否是回文子串且i、j位置是否相等
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);

                // 如果当前[i...j]是回文子串且子串长度比之前求的大，则更新start和step
                if (dp[i][j] && j - i + 1 > step) {
                    start = i;
                    step = j - i + 1;
                }
            }

        }

        return s.substring(start, start + step);
    }


    public static void main(String[] args) {
        String s = "aba";
        System.out.println(s.substring(0, 1));
    }
}
