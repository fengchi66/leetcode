package leetcode.editor.code;

//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 545 👎 0

public class IntegerBreak{
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {

        // 定义数组定义0到n长度的绳子减掉后的最大乘积
        int[] dp = new int[n];
        dp[2] = 1;

        for (int i = 3; i < n; i++) {
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}