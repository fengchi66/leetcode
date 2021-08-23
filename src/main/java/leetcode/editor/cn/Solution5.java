package leetcode.editor.cn;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 4005 👎 0

/**
 * date: 2021-08-23 00:07:41
 * title: 最长回文子串
 */
public class Solution5 {
    public static void main(String[] args) {
        Solution solution = new Solution5().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 2)
                return s;

            // dp[i][j]表示s[i...j是否是回文子串]
            int len = s.length();
            boolean[][] dp = new boolean[len][len];

            // 最长子串开始的位置以及跨越的长度
            int start = 0;
            int step = 1;

            // base case,只有一个字符一定是回文
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            // base case, 当j == i+1时，看值是不是相等
            for (int i = 0; i < len; i++) {
                dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (dp[i][i + 1]) {
                    start = i;
                    step = 2;
                }
            }

            // 普遍情况
            for (int i = len - 3; i >= 0; i++) {
                for (int j = i + 2; j < len; j++) {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}