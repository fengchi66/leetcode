package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 
// 👍 1549 👎 0

public class HouseRobber{
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        int[] arr = {2,4,0,4,7,8,3,6};
        System.out.println(solution.rob(arr));
        System.out.println(solution.rob2(arr));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        return process(nums, 0);

    }
    // 从左到右的尝试模型: 从index位置出发能偷到的最多的钱
    public int process(int[] arr, int index) {

        if (index == arr.length) // 不能再抢了
            return 0;
        if (index > arr.length)
            return -1;

        // 偷
        int p1 = arr[index];
        int next = process(arr, index +2);
        if (next != -1)
            p1 += next;

        // 不偷
        int p2 = process(arr, index +1);

        return Math.max(p1, p2);
    }

    // 定义dp
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // dp[index]表示在index位置开始，剩下的自由偷的最多钱
        int N = nums.length;
        int[] dp = new int[N + 2];
        // base case
        dp[N] = 0;
        // dp[index]位置的值依赖于dp[index+1]或者dp[index+2]的值
        for (int index = N-1; index >=0 ; index--) {
            dp[index] = Math.max(dp[index +2] + nums[index], dp[index +1]);
        }
        return dp[0];
    }

    // 定义dp
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        // dp[index]表示在index位置开始，剩下的自由偷的最多钱
        int N = nums.length;
        int[] dp = new int[N + 2];
        // base case
        dp[N] = 0;
        // dp[index]位置的值依赖于dp[index+1]或者dp[index+2]的值
        for (int index = N-1; index >=0 ; index--) {
            dp[index] = Math.max(dp[index +2] + nums[index], dp[index +1]);
        }
        return dp[0];
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}