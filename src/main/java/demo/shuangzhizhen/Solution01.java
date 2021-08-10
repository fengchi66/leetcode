package demo.shuangzhizhen;

import java.util.Arrays;

// 88合并两个有序数组
public class Solution01 {
    // 其实就是归并排序的merge过程
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] arr = new int[m + n];
        int i = 0; // 记录arr数组的下标
        int p1 = 0;
        int p2 = 0;

        // 比较p1、p2位置的大小，将元素copy到arr数组中
        while (p1 < m && p2 < n)
            arr[i++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];

        // 此时要么nums1越界，要么nums2越界
        while (p1 < m) arr[i++] = nums1[p1++];
        while (p2 < n) arr[i++] = nums2[p2++];

        for (i = 0; i < arr.length; i++)
            nums1[i] = arr[i];

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }
}
