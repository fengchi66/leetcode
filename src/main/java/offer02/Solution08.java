package offer02;

// 剑指 Offer II 008. 和大于等于 target 的最短子数组长度
public class Solution08 {

    // 动态规划 待修正
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // 范围dp模型，dp[i][j]表示在nums[i...j]范围内子数组的和
        int N = nums.length;
        int[][] dp = new int[N][N];
        int ans = 0;

        // base case
        for (int i = 0; i < N; i++) {
            dp[i][i] = nums[i];
            ans = nums[i] >= target ? 1 : 0;
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                int p1 = dp[i + 1][j - 1] + nums[i] + nums[j];
                int p2 = dp[i][j + 1] + nums[j];
                int p3 = dp[i - 1][j] + nums[i];
                if (dp[i][j] >= target)
                    ans = Math.min(ans, j - i + 1);
            }
        }
        return ans;
    }

    // 同向双指针:时间复杂度0(N)
    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int L = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int R = 0; R < nums.length; R++) {
            // 在当前L下，一直将nums[R]加到sum上面
            sum += nums[R];
            // 当sum >= target的时候,计算出最小长度；同时将sum中减去num[L],然后L指针右移，相当于sum维护了nums[L...R]的和
            while (L <= R && sum >= target) {
                minLength = Math.min(minLength, R - L + 1);
                sum -= nums[L];
                L++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0: minLength;
    }
}
