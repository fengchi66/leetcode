package code.class25;

import java.util.Arrays;
import java.util.Stack;

public class Code01_MonotonousStack {

    // arr = [ 3, 1, 2, 3]
    //         0  1  2  3
    //  [
    //     0 : [-1,  1]
    //     1 : [-1, -1]
    //     2 : [ 1, -1]
    //     3 : [ 2, -1]
    //  ]

    public static int[][] getNearLessNoRepeat(int[] arr) {
        // 结果：N * 2的二维数组
        int[][] res = new int[arr.length][2];
        // 栈中存的是数组的位置，而不是值
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) { // 当遍历到i位置的数，arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) { // 栈不为空且当前元素比栈顶小
                int j = stack.pop();
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[j][0] = leftLessIndex;
                res[j][1] = i;
            }
            stack.push(i);
        }
        // 将剩余的栈中的元素弹出
        while (!stack.isEmpty()) {
            int j = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[j][0] = leftLessIndex;
            res[j][1] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,6,1,7,0};
        int[][] ints = getNearLessNoRepeat(arr);

        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
