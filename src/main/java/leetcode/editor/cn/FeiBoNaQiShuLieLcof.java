package leetcode.editor.cn;

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 155 👎 0

public class FeiBoNaQiShuLieLcof{
    public static void main(String[] args) {
        Solution solution = new FeiBoNaQiShuLieLcof().new Solution();

        int fib = solution.fib2(48);
        System.out.println(fib);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 使用递归
     * @param n
     * @return
     */
    public int fib(int n) {

        if (n <1)  return 0;

        // 定义一个备忘录，存贮中间结果，并将值初始化为0
        int[] memo = new int[n + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 0;
        }

        return helper(memo, n);



    }

    int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;

        // 已经计算过
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];

    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int fib2(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        // dp
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = dp[2] = 1;

        for (int i = 3; i < n +1; i++) {
            // 状态转移方程
            dp[i] = (dp[i-2] + dp[i- 1]) % 1000000007;
        }

        return dp[n];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}