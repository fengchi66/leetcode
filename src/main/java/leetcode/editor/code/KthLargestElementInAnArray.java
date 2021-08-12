package leetcode.editor.code;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1203 👎 0

// 215. 数组中的第K个最大元素
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return process(nums, 0, nums.length - 1, k);
        }

        //  在num[L...R]范围内，对nums降序排序，并返回第K大的元素
        public int process(int[] nums, int L, int R, int k) {
            int pos = partition(nums, L, R);
            // base case
            if (pos + 1 == k) return nums[pos];

            // 如果pos + 1 < k,，说明第K大元素在nums[pos+1,R]中，否则在nums[L，pos-1]中
            return pos + 1 < k ? process(nums, pos + 1, R, k) : process(nums, L, pos - 1, k);
        }

        // 分区
        public int partition(int[] nums, int L, int R) {
            // 基准值
            int cur = nums[R];
            int i = L - 1;
            for (int j = L; j <= R - 1; j++) {
                if (nums[j] >= cur) {
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