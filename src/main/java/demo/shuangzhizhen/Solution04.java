package demo.shuangzhizhen;

import java.util.HashSet;

// 26. 删除有序数组中的重复项
public class Solution04 {
    public int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        int l = 1, r = 1;
        while (r < nums.length) {
            if (nums[r] != nums[r-1]) {
                nums[l] = nums[r];
                    l++;
            }
            r++;
        }
        return l;
    }

}
