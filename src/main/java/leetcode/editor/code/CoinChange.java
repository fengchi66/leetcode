package leetcode.editor.code;

//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1365 👎 0

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();

        int[] arr = {1, 2, 5};
        int aim = 11;
        System.out.println(solution.coinChange(arr, aim));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {

            if (coins == null || coins.length == 0)
                return 0;

            int ans = process(coins, 0, amount);
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }

        // 在index位置开始，所有的钱可以自由选择，凑齐刚好rest这么多钱
        public int process(int[] coins, int index, int rest) {
            // base case
            if (rest < 0) // 无效
                return Integer.MAX_VALUE;
            if (index == coins.length) // 没有钱可以选了,且刚好rest==0
                return rest == 0 ? 0 : Integer.MAX_VALUE;

            int ans = Integer.MAX_VALUE;
            // 在index位置，还有钱可以选，每张钱可以选0张或者多张,但剩余的钱不能超过rest
            for (int zhang = 0; zhang * coins[index] <= rest; zhang++) {
                int next = process(coins, index + 1, rest - zhang * coins[index]);
                if (next != Integer.MAX_VALUE)
                    ans = Math.min(ans, zhang + next);
            }
            return ans;
        }

        // 动态规划：在index位置开始，所有的钱可以自由选择，凑齐刚好rest这么多钱最少硬币数
        public int coinChange2(int[] coins, int amount) {
            if (coins == null || coins.length == 0)
                return 0;

            int N = coins.length;
            int[][] dp = new int[N + 1][amount + 1];
//        dp[N][0] = 0;
            for (int j = 1; j <= amount; j++) {
                dp[N][j] = Integer.MAX_VALUE;
            }
            for (int index = N - 1; index >= 0; index--) {
                for (int rest = 0; rest <= amount; rest++) {
                    int ans = Integer.MAX_VALUE;
                    for (int zhang = 0; zhang * coins[index] <= rest; zhang++) {
                        int next = dp[index + 1][rest - zhang * coins[index]];
                        if (next != Integer.MAX_VALUE)
                            ans = Math.min(ans, zhang + next);
                    }
                    dp[index][rest] = ans;
                }

            }
            return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
        }

        public int coinChange3(int[] coins, int amount) {
            if (coins == null || coins.length == 0)
                return 0;

            int N = coins.length;
            int[][] dp = new int[N + 1][amount + 1];
//        dp[N][0] = 0;
            for (int j = 1; j <= amount; j++) {
                dp[N][j] = Integer.MAX_VALUE;
            }
            for (int index = N - 1; index >= 0; index--) {
                for (int rest = 0; rest <= amount; rest++) {
                    if (rest - coins[index] >= 0 && dp[index][rest - coins[index]] != Integer.MAX_VALUE) {
                        dp[index][rest] = Math.min(dp[index + 1][rest], dp[index][rest - coins[index]] + 1);
                    }
                }

            }
            return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}