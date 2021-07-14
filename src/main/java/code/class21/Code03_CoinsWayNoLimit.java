package code.class21;

/**
 * 凑整钱
 */
public class Code03_CoinsWayNoLimit {

    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    // arr[index....] 所有的面值，每一个面值都可以任意选择张数，组成正好rest这么多钱，方法数多少？
    // 穷举所有可能的情况：每一个index位置的钱可以选0到多张，但总面值不大于rest
    public static int process(int[] arr, int index, int rest) {
        // base case,每一张钱都选完了，且rest == 0
        if (index == arr.length)
            return rest == 0 ? 1 : 0;

        // 还有钱可以选，可以选0张或多张
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process(arr, index + 1, rest - zhang * arr[index]);
        }
        return ways;
    }

    // 动态规划
    public static int coinsWay2(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // 状态值至于index与rest有关,index:[0,N],rest:[aim,0]
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // base case
        dp[N][0] = 1;

        // dp[index]依赖于dp[index +1]的值
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                // 注意这里dp[index][rest]的值应该是选择0张或者多张钱数的可能性和
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }

        }
        return dp[0][aim];
    }

    public static int coinsWay3(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // 状态值至于index与rest有关,index:[0,N],rest:[aim,0]
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        // base case
        dp[N][0] = 1;

        // dp[index]依赖于dp[index +1]的值
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                // 注意这里dp[index][rest]的值应该是选择0张或者多张钱数的可能性和
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }

        }
        return dp[0][aim];
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 5, 10};
        int aim = 100;

        System.out.println(coinsWay(arr, aim));
        System.out.println(coinsWay2(arr, aim));
    }
}
