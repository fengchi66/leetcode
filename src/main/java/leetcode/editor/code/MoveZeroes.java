package leetcode.editor.code;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1100 👎 0

public class MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        // 双指针法
        int l = 0, r = 0;

        while (r < nums.length) {

            // 如果右指针的值不为0，则左指针向右移动，且交换值
            if (nums[r] != 0) {
                swap(nums, l, r);
                l ++;
            }
            r ++;
        }

    }

    // 数组值交换
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}