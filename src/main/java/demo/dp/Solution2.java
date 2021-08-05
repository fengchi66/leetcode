package demo.dp;

import java.util.Arrays;

/**
 * 最长上升子序列的长度
 */
public class Solution2 {

    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int N = nums.length;
        // dp[i]表示nums[0...i]位置最长上升子序列的长度
        int[] dp = new int[N];
        // base case
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] +1);
            }
            ans = Math.max(dp[i], ans);

        }
        return ans;
    }
}
