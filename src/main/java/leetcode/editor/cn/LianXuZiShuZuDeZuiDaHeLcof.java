package leetcode.editor.cn;

//输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。 
//
// 要求时间复杂度为O(n)。 
//
// 
//
// 示例1: 
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// -100 <= arr[i] <= 100 
// 
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/ 
//
// 
// Related Topics 数组 分治 动态规划 
// 👍 298 👎 0

public class LianXuZiShuZuDeZuiDaHeLcof{
    public static void main(String[] args) {
        Solution solution = new LianXuZiShuZuDeZuiDaHeLcof().new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        solution.maxSubArray(nums);

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

}
//leetcode submit region end(Prohibit modification and deletion)

}