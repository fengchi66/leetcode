package code.class18;

import java.security.Key;

/**
 * 机器人到达指定位置方法数
 */
public class Code01_RobotWalk {

    // 暴力递归法
    public static int ways1(int N, int start, int aim, int k) {
        return process1(start, k, aim, N);
    }

    /**
     * @param cur  机器人当前来到的位置是cur
     * @param rest 机器人还需要rest步需要走
     * @param aim  最终的目标是aim
     * @param N    有哪些位置：1-N
     * @return 机器人从cur出发，走过rest步后，最终停在aim的方法数是多少
     */
    public static int process1(int cur, int rest, int aim, int N) {
        // base case,
        if (rest == 0) // 已经不需要走了，走完了
            return cur == aim ? 1 : 0;

        // rest > 0，还有步数要走
        if (cur == 1) // 机器人在1位置，只能走到2
            return process1(2, rest - 1, aim, N);
        if (cur == N) // 机器人在N位置，只能走到N -1位置
            return process1(N - 1, rest - 1, aim, N);
        else // 如果在中间位置，既可以向左也可以向右走
            return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);

    }

    // 傻缓存法
    public static int ways2(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        // dp就是缓存表
        // process2(cur, rest)之前没算过！dp[cur][rest] == -1
        // process2(cur, rest)之前没算过！dp[cur][rest] != -1,返回值放在dp[cur][rest]

        return process2(start, K, aim, N, dp);
    }

    /**
     * @param cur  范围：1-N
     * @param rest 范围：0-K
     * @param aim
     * @param N
     * @return
     */
    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) // 之前已经算过，直接返回
            return dp[cur][rest];

        // 之前没算过
        int ans = 0;
        if (rest == 0) // 已经不需要走了，走完了
            ans = cur == aim ? 1 : 0;
        else if (cur == 1) // 机器人在1位置，只能走到2
            ans = process2(2, rest - 1, aim, N, dp);
        if (cur == N) // 机器人在N位置，只能走到N -1位置
            ans = process2(N - 1, rest - 1, aim, N, dp);
        else // 如果在中间位置，既可以向左也可以向右走
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);

        dp[cur][rest] = ans;
        return ans;
    }

    // 动态规划
    public static int ways3(int N, int start, int aim, int K) {
        int[][] dp = new int[N + 1][K + 1];

        // 只有rest == 0且cur == aim时，dp为1，剩余都是0
        dp[aim][0] = 1;

        for (int rest = 1; rest <= K; rest++) { // 列
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) { // 行
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }

        return dp[start][K];
    }
}
