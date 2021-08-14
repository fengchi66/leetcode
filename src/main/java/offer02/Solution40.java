package offer02;

import java.util.Stack;

// 剑指 Offer II 040. 矩阵中最大的矩形
public class Solution40 {
    public int maximalRectangle(char[][] matrix) {
        // 矩形的高或者宽为0，直接返回0
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;

        // 将问题转化为求柱状图的最大面积的问题
        // 将矩阵中上下相邻的格子看成直方图的柱子
        int[] nums = new int[matrix[0].length];
        int ans = 0;

        for (char[] chars : matrix) {
            // chars就是矩阵中的每一行
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '0') // 如果格子的值为0，则为0
                    nums[i] = 0;
                else // 如果不为0，则加1
                nums[i] ++;
            }
            ans = Math.max(ans, largestRectangleArea(nums));
        }

        return ans;

    }

    // 求直方图中的最大矩形面积
    private int largestRectangleArea(int[] nums) {
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
