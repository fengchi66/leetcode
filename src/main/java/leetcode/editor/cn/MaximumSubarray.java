package leetcode.editor.cn;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治 动态规划 
// 👍 3417 👎 0

import java.util.Arrays;

public class MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution.maxSubArray(nums));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;

        return process(nums, 0, nums.length -1);
    }

    // 范围尝试模型:在[L,R]范围内数组的最大和
    public int process(int[] nums, int L, int R) {
        if (L > R) return 0;
        // base case
        if (L == R)
            return nums[L];


        // 4种情况
        int p1 = process(nums, L+1, R);
        int p2 = process(nums, L, R-1);
        int p3 = nums[R] + nums[L] + process(nums, L+1, R-1);
        int p4 = process(nums, L+1, R-1);

        return Math.max(Math.max(p1, p2), Math.max(p3, p4));
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length ==0)
            return 0;

        int N = nums.length;
        // dp[i]表示以nums[i]结尾的最大子序和
        int[] dp = new int[N];
        // base case
        dp[0] = nums[0];

        // 遍历数组,在位置时判断是否抛弃i之前的子串
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(nums[i] + dp[i-1], nums[i]);
        }
        // 返回dp数组的最大值
        return Arrays.stream(dp).max().getAsInt();

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}