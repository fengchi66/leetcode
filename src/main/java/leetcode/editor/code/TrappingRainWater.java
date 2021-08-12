package leetcode.editor.code;

import java.util.Stack;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2496 👎 0
// 42: 接雨水
public class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        // 单调栈，栈底到栈顶单调递减，但不递减时，就可以接住雨水
        // 实际上把问题转化为：寻找数组元素左右两边最近的比它大的元素，经典的单调栈问题
        int ans = 0;
        // 单调栈 存索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                // 要被弹出的数
                int cur = stack.pop();
                if (stack.isEmpty())
                    break;
                // 左边最近比cur高的数是pre
                int pre = stack.peek();
                // 右边最近比cur高的数是 height[i])
                int currWidth = i - pre - 1;
                // 取min存在两种情况：
                int currHeight = Math.min(height[pre], height[i]) - height[cur];
                ans += currWidth * currHeight;

            }
            stack.push(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}