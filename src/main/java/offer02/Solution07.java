package offer02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 剑指 Offer II 007. 数组中和为 0 的三个数
public class Solution07 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();

        if (nums.length >= 3) {
            Arrays.sort(nums);

            // 先固定一个数
            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i,ans);
                int temp = nums[i];
                while (i< nums.length && nums[i] == temp) {
                    i++;
                }
            }
        }

        return ans;

    }

    // 在i确定的情况下两数之和
    private void twoSum(int[] nums, int i, List<List<Integer>> ans) {
        int j = i + 1;
        int k = nums.length - 1;

        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                // 将此时nums[j]的数记下来，迭代剩下的数，如果和num[j]相等，就不再计算，直接j++
                int temp = nums[j];
                while (nums[j] == temp && j < k) {
                    j++;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
}
