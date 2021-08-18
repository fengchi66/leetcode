package offer02;

// 剑指 Offer II 068. 查找插入位置
public class Solution68_02 {

    // 变体三：查找第一个大于等于给定值的元素
    public int searchInsert(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target)
                    return mid;
                else R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return nums.length;
    }
}
