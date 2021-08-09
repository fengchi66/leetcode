package offer02;

// 剑指 Offer II 009. 乘积小于 K 的子数组
public class Solution09 {
    // 同向双指针
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;

        int L = 0;
        int count = 0;
        int sum = 1;

        for (int R = 0; R < nums.length; R++) {
            sum *= nums[R];
            while (L <= R && sum >= k) {
                sum = sum / nums[L];
                L++;
            }
            count += R - L + 1;
        }
        return count;
    }

}
