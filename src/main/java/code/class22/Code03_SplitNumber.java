package code.class22;

public class Code03_SplitNumber {

    // n为正整数
    public static int way(int n) {
        if (n <0)
            return 0;
        if (n == 1)
            return 1;

        return process(1, n);
    }

    // 上一个拆出来的数是pre，还剩rest需要去拆
    // 返回拆解的方法数
    public static int process(int pre, int rest) {
        // base case
        if (pre > rest) // 拆出来的前一个数大于rest
            return 0;

        if (pre == rest) // pre等于rest，rest不能再拆了,是一种有效方法
            return 1;

        // pre < rest
        int ways = 0;
        for (int first = 0; first <= rest; first++) {
            ways += process(first, rest - first);
        }
        return ways;
    }

    // 动态规划
    public static int way2(int n) {
        if (n <0)
            return 0;
        if (n == 1)
            return 1;

        int[][] dp = new int[n + 1][n + 1];
        for (int pre = 1; pre <= n; pre++) {
            dp[pre][0] = 1;
            dp[pre][pre] = 1;
        }
        for (int pre = n - 1; pre >= 1; pre--) {
            for (int rest = pre + 1; rest <= n; rest++) {
                int ways = 0;
                for (int first = pre; first <= rest; first++) {
                    ways += dp[first][rest - first];
                }
                dp[pre][rest] = ways;
            }
        }
        return dp[1][n];
    }
}
