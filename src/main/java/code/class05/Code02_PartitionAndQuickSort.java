package code.class05;

import java.util.Arrays;

/**
 * 快排
 */
public class Code02_PartitionAndQuickSort {

    public static void quickStart(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        process(nums, 0, nums.length - 1);
    }

    // 对nums[L...R]上的元素进行排序
    public static void process(int[] nums, int L, int R) {
        // base case
        if (L >= R) return;

        int pos = partition(nums, L, R);
        process(nums, L, pos - 1);
        process(nums, pos + 1, R);
    }

    // 分区
    public static int partition(int[] nums, int L, int R) {
        // 以nums[R]位置上的数作为基准值
        int pivot = nums[R];
        // 初始化i = L - 1表示一开始小于pivot的范围为0
        int i = L - 1;
        for (int j = L; j <= R - 1; j++) {
            // 当遍历时出现当前的数小于基准值，则i++,然后将i和j位置的数交换
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        // 最后将R位置的数和i+1位置的数交换，此时i + 1位置的数就是这个基准值，然后换回
        swap(nums, i + 1, R);
        return i + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 1, 3, 5, 6, 4};
        quickStart(arr);
        System.out.println(Arrays.toString(arr));
    }
}
