package leetcode.editor.code;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 贪心 数组 双指针 
// 👍 2564 👎 0

public class ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

        // 定义双指针
        int low = 0;
        int high = height.length - 1;

        // 结果
        int res = 0;

        while (low < high) {
            // 此时容器的大小
            int i = Math.min(height[high], height[low]) * (high - low);
            // 这里始终维持res的最大值，最后将res返回即可
            res = Math.max(res, i);

            // 如果左边界比右边界小，向右移动左边界,反之向左移动右边界
            if (height[low] <= height[high])
                low ++;
            else
                high -- ;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}