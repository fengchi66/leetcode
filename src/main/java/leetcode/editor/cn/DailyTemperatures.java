package leetcode.editor.cn;

//请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 105 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics 栈 数组 单调栈 
// 👍 815 👎 0

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = solution.dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] arr) {
            if (arr == null || arr.length == 0)
                return new int[0];

            // 单调栈结构，栈底到栈顶递减
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                    int pre = stack.pop();
                    res[pre] = i - pre;
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}