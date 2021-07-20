package code.class25;

import java.util.Stack;

// leetcode 84: 柱状图最大面积
public class Code03_LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;

        // 存索引
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        // 维持单调栈结构：对每个元素而言，左右两边最近的不小于heights[i]的元素都可以扩展
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * heights[j];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        // 弹出剩余栈中元素,也就是数组递增之前没有弹出的元素
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (heights.length - k - 1) * heights[j];
            maxArea = Math.max(maxArea, curArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(arr));

    }

}
