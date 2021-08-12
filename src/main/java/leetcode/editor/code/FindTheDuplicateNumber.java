package leetcode.editor.code;

//给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。 
//
// 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。 
//
// 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2,2]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,3,4,2]
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：nums = [1,1,2]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次 
// 
//
// 
//
// 进阶： 
//
// 
// 如何证明 nums 中至少存在一个重复的数字? 
// 你可以设计一个线性级时间复杂度 O(n) 的解决方案吗？ 
// 
// Related Topics 位运算 数组 双指针 二分查找 
// 👍 1256 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {

            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int num : nums) {
                if (map.get(num) == null) // map中没有该元素的key，存进去
                    map.put(num, 1);
                else // 已经有了，当前的元素就是重复元素
                    return num;
            }
            return -1;
        }

        public int findDuplicate2(int[] nums) {

            HashSet<Integer> set = new HashSet<Integer>();

            for (int num : nums) {
                if (!set.contains(num))
                    set.add(num);
                else
                    return num;
            }
            return -1;
        }

        // 先排序, 然后找相邻的相同元素,
        public int findDuplicate3(int[] nums) {

            // 排序
            Arrays.sort(nums);

            // 遍历数组元素，遇到跟前一个相同的，就是相邻元素
            for (int i = 1; i < nums.length; i++)
                if (nums[i] == nums[i - 1])
                    return nums[i];

            return -1;
        }

        // 二分查找
        public int findDuplicate4(int[] nums) {

            int l = 1;
            int r = nums.length - 1;

            // 二分查找
            while (l <= r) {
                int i = (l + r) / 2;
                // 对当前i计算count[i]
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] <= i)
                        count++;
                }
                // 判断count[i]和i的大小关系
                if (count <= i)
                    l = i + 1;
                else
                    r = i;
                // 找到target
                if (l == r)
                    return l;
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}