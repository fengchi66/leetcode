package offer02;

// 剑指 Offer II 076. 数组中的第 k 大的数字
public class Solution76_02 {
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    // 递归函数,在nums[L...R]上找到第k大的数字
    private int find(int[] nums, int k, int L, int R) {
        if (L >= R) return nums[L];

        // mid + 1与k比较
        int mid = partition(nums, L, R);
        if (mid + 1 == k) return nums[mid];
        else if (mid + 1 < k) return find(nums, k, mid + 1, R);
        else return find(nums, k, L, mid - 1);
    }

    // 分区，降序
    private int partition(int[] nums, int L, int R) {
        int cur = nums[R];
        int i = L - 1;
        for (int j = L; j <= R - 1; j++) {
            if (nums[j] >= cur) {
                i++;
                swap(nums, i, j);
            }
        }
        // 然后将cur与i+1位置交换
        swap(nums, i + 1, R);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
