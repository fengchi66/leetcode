package offer02;

import java.util.HashMap;

// 剑指 Offer II 010. 和为 k 的子数组个数
public class Solution10 {

    // 前缀和 + 哈希表
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        // 存储数组的前个元素和的大小和次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            // sum - k出现的次数，也就是和为k的子数组个数
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }

}
