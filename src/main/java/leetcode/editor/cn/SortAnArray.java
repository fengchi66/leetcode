package leetcode.editor.cn;

//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 
// 👍 329 👎 0

public class SortAnArray {
    public static void main(String[] args) {
        Solution solution = new SortAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            if (nums == null || nums.length < 2)
                return nums;

            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        // 快速排序:在nums[L...R]范围内排序
        public void quickSort(int[] nums, int L, int R) {
            // base case
            if (L >= R) return;
            int pos = partition(nums, L, R);
            quickSort(nums, L, pos - 1);
            quickSort(nums, pos + 1, R);
        }

        public int partition(int[] nums, int L, int R) {
            // 基准值
            int cur = nums[R];
            int i = L - 1;
            for (int j = L; j <= R - 1; j++) {
                if (nums[j] <= cur) {
                    i++;
                    swap(nums, i, j);
                }
            }
            swap(nums, i + 1, R);
            return i + 1;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}