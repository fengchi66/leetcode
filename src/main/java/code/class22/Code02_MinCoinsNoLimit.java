package code.class22;

/**
 * 凑钱最少货币数
 */
public class Code02_MinCoinsNoLimit {


    public static int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0)
            return 0;

        return process(arr, 0, aim);
    }

    // 从左到右尝试:从index位置开始，所有货币任意选择，凑齐刚好rest这么多钱
    public static int process(int[] arr, int index, int rest) {
        if (rest < 0) // 无效
            return Integer.MAX_VALUE;
        // base case: 没钱了且刚好rest==0
        if (index == arr.length)
            return rest == 0 ? 0 : Integer.MAX_VALUE;

        // 常规情况，每张钱可以选择0张或多张,但不能超过rest
        int ans = Integer.MAX_VALUE;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            int next = process(arr, index + 1, rest - zhang * arr[index]);
            if (next != Integer.MAX_VALUE)
                ans = Math.min(ans, next + zhang);
        }
        return ans;
    }

    // 动态规划:
    public static int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0)
            return 0;

        int N = arr.length;
        // dp[index][rest]表示在index位置，剩余的钱可以自由选，组成rest的最小货币数量
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int j = 1; j <= aim; j++)
            dp[N][j] = Integer.MAX_VALUE;

        // 常规情况，每张钱可以选择0张或多张,但不能超过rest
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ans = Integer.MAX_VALUE;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    int next = dp[index + 1][rest - zhang * arr[index]];
                    if (next != Integer.MAX_VALUE)
                        ans = Math.min(ans, next + zhang);
                }
                dp[index][rest] = ans;
            }
        }
        return dp[0][aim];
    }

    public static int dp2(int[] arr, int aim) {
        if (aim == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 0;
        for (int j = 1; j <= aim; j++) {
            dp[N][j] = Integer.MAX_VALUE;
        }
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0
                        && dp[index][rest - arr[index]] != Integer.MAX_VALUE) {
                    dp[index][rest] = Math.min(dp[index][rest], dp[index][rest - arr[index]] + 1);
                }
            }
        }
        return dp[0][aim];
    }


}
