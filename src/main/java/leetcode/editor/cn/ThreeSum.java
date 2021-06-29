package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3441 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
    // 暴力法
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i = 0; i < n -2; i ++)
            for( int j = i + 1; j < n - 1; j++ )
                for( int k = j + 1; k < n; k++ )
                    if (nums[i] + nums[j] + nums[k] == 0)
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));

        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}