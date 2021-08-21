package offer02;

import java.util.Arrays;

// 归并排序与快速排序
// TODO 归并排序是自下而上的递归，快排是自上而下的递归
public class Solution76_01 {

    int[] tmp;

    /**
     * 归并排序:是一个自下而上的递归过程，类似DFS中的后序遍历
     *
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    // 递归函数，将nums[L...R]上升序排序
    private void mergeSort(int[] nums, int L, int R) {
        // base case
        if (L == R) return;

        // 找到数组中间位置
        int mid = (L + R) >> 1;

        // 将数组的nums[L, mid]以及nums[mid+1, R]上进行排序
        mergeSort(nums, L, mid);
        mergeSort(nums, mid + 1, R);

        // 此时nums[L, mid]以及nums[mid+1, R]上已经是排好序的了
        // 双指针
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= R)
            tmp[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        // 要么p1还没到走完要么p2还没走完
        while (p1 <= mid) tmp[i++] = nums[p1++];
        while (p2 <= R) tmp[i++] = nums[p2++];

        // 将临时数组的元素拷贝到原来数组中后，nums[L...R]就是有序的了
        for (int j = 0; j < R - L + 1; j++) {
            nums[L + j] = tmp[j];
        }
    }

    /**
     * 快速排序
     *
     * @param nums
     * @return
     */
    public int[] sortArray2(int[] nums) {
        quickStart(nums, 0, nums.length - 1);
        return nums;
    }

    // 递归函数，在nums[L...R]范围内排序
    private void quickStart(int[] nums, int L, int R) {
        // base case
        if (L >= R) return;
        // 自上而下递归，先对范围大的数组分区，然后分支分区，知道base case不能再分区为止
        int mid = partition(nums, L, R);
        quickStart(nums, L, mid - 1);
        quickStart(nums, mid + 1, R);
    }

    // 分区
    private int partition(int[] nums, int L, int R) {
        // 基准值
        int cur = nums[R];
        int i = L - 1;
        for (int j = L; j <= R - 1; j++) {
            if (nums[j] <= cur) {
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

    public static void main(String[] args) {
        int[] nums = {11, 8, 3, 9, 7, 1, 2, 5};
        Solution76_01 impl = new Solution76_01();
        System.out.println(Arrays.toString(impl.sortArray1(nums)));


    }
}
