package offer02;

import java.util.Stack;

// 剑指 Offer II 038. 每日温度
// 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
public class Solution38 {

    // 单调栈：实际上是求每个位置右边最近的比它大的数，栈底到栈顶单调递减
    public int[] dailyTemperatures(int[] nums) {
        int[] ans = new int[nums.length];

        // 单调栈
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            // 当当前的数比栈顶大时候，弹出，维持单调递减栈，此时栈顶元素就是'低温'
            while (!stack.empty() && nums[i] > nums[stack.peek()]) {
                int cur = stack.pop();
                ans[cur] = i - cur;
            }
            stack.push(i);
        }
        // 此时栈中可能还有元素没有弹出，且栈底到栈顶单调递减
        // 如果气温在这之后都不会升高，请在该位置用 0 来代替。所以不需要继续弹出了
        return ans;
    }

}
