package leetcode.editor.code;

//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//
// 
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。 
// 
//
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 
//
// 示例 2： 
//
// 
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 
//
// 示例 3： 
//
// 
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text1.length, text2.length <= 1000 
// text1 和 text2 仅由小写英文字符组成。 
// 
// Related Topics 字符串 动态规划 
// 👍 605 👎 0

// 1143:最长公共子序列
public class LongestCommonSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestCommonSubsequence().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
            return 0;

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();

        return f(arr1, arr1,  arr1.length-1,  arr2.length-1);
    }

    // str1:[0...i]和str2:[0...j]的公共子序列长度
    public int f(char[] str1, char[] str2, int i, int j) {
        // base case
        if (i == 0 && j == 0)
            return str1[i] == str2[j] ? 1: 0;
        if (i == 0)
            return str1[i] == str2[j] ? 1: f(str1, str2, i, j -1);
        if (j == 0)
            return str1[i] == str2[j] ? 1: f(str1, str2, i-1, j);
        // 常规情况
        // 公共子序列以str1结尾
        int p1 = f(str1, str2, i -1, j);
        // 以str2结尾
        int p2 = f(str1, str2, i , j-1);
        // 既以str1结尾也以str2结尾
        int p3 = str1[i] == str2[j] ? 1 + f(str1, str2, i -1, j-1): 0;

        return Math.max(p1, Math.max(p2, p3));

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}