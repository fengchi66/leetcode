package leetcode.editor.code;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 476 👎 0

// 516. 最长回文子序列
public class LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] arr = s.toCharArray();
        int N = arr.length;
        // 1. dp[i][j]的含义是arr[i,j]内的最长回文子序列
        int[][] dp = new int[N][N];
        // 2. base case
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        // 3. 状态转移
        for (int i = N-2; i >=0 ; i--) {
            for (int j = i+1; j < N; j++) {
                // 判断i和j位置是否相等
                if (arr[i] == arr[j])
                    dp[i][j] = 2 + dp[i+1][j-1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][N-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}