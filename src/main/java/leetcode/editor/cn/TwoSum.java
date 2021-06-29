package leetcode.editor.cn;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11395 👎 0

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();

        int[] nums = {1, 3, 5, 4, 8};

        int[] ints = solution.twoSum(nums, 6);

//        System.out.println(Arrays.toString(ints));

        int[] ints1 = twoSum2(nums, 8);
        System.out.println(Arrays.toString(ints1));

    }

    /**
     * 两遍哈希法:
     * 1. 遍历将数组的值、索引加入hash表
     * 2. 遍历判断 target - i 是否在hash表中
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum2(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 遍历数组，加入到hashMap中
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        // 遍历数组，
        for (int i = 0; i < nums.length; i++) {
            int lag = target - nums[i];
            if (map.containsKey(lag) && map.get(lag) != i)
                return new int[]{i, map.get(lag)};
        }
        return new int[]{};
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    // 1. 暴力法
    class Solution {
        public int[] twoSum(int[] nums, int target) {

            for (int i = 0; i < nums.length; i++)
                for (int j = i + 1; j < nums.length; j++)
                    if (nums[i] + nums[j] == target)
                        return new int[]{i, j};
            return new int[]{};

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}