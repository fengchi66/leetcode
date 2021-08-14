package offer02;

import java.util.Stack;

// 剑指 Offer II 039. 直方图最大矩形面积
public class Solution39 {
    public int largestRectangleArea(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] <= nums[stack.peek()]) {
                // 当前弹出的元素就是高
                int n = nums[stack.pop()];
                // stack.peek()表示当前弹出的元素之前的元素，也就是上一个位置比他小的数
                int pre = stack.isEmpty() ? -1: stack.peek();
                int m = i - pre -1;
                ans = Math.max(ans, m * n);
            }
            stack.push(i);
        }

        // 剩下的没弹出的元素，都是递增的
        while (!stack.isEmpty()) {
            // 当前弹出的元素就是高
            int n = nums[stack.pop()];
            // 右边的元素都比它高
            int pre = stack.isEmpty() ? -1: stack.peek();
            int m = nums.length - pre -1;
            ans = Math.max(ans, m * n);
        }
        return ans;
    }
}
