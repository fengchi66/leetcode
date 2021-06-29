package leetcode.editor.cn;

//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1032 👎 0

public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();

        int[] nums = {2, 3, 1, 2, 4, 2, 3};
        solution.jump(nums);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jump(int[] nums) {

            int length = nums.length;
            int end = 0; // 上次跳跃可达范围右边界（下次的最右起跳点）
            int maxPosition = 0;  // 目前能跳到的最远位置
            int steps = 0;
            for (int i = 0; i < length - 1; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
                System.out.println(maxPosition);

                // 到达上次跳跃能到达的右边界了
                if (i == end) {
                    end = maxPosition; // 目前能跳到的最远位置变成了下次起跳位置的有边界
                    steps++; // 进入下一次跳跃
                }
            }
            return steps;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}