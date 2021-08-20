package offer02;

// 剑指 Offer II 070. 排序数组中只出现一次的数字
public class Solution70 {
    public int singleNonDuplicate(int[] nums) {
        // 将长度为n的数组分为n/2 +1组，L是查找范围第一个分组的编号，R是最后一个分组的编号
        int L = 0;
        int R = nums.length / 2;

        while (L <= R) {
            int mid = (L + R) / 2; // 先查中间位置
            int i = mid * 2; // i表示mid这个组中的第一个元素在原数组中的索引
            // base case
            if (i < nums.length - 1 && nums[i] != nums[i + 1]) { // 此时可以确定这一组中两个元素不相等，但不能确定是第一组
                if (mid == 0 || nums[i - 2] == nums[i - 1]) // 如果是在第一组或者前一组的元素相等，那么可以返回
                    return nums[i];
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        // 如果经过以上还没有返回i，那么一定在数组的最后一个元素
        return nums[nums.length - 1];
    }

}
