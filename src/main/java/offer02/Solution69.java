package offer02;

// 剑指 Offer II 069. 山峰数组的顶部
public class Solution69 {
    public int peakIndexInMountainArray(int[] arr) {
        // 第一个和最后一个数肯定不是最大值
        int L = 1;
        int R = arr.length - 2;

        // 最大值的特征是它的左边和右边的数字都比它小
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;

            // 说明当前mid在上升部分
            if (arr[mid] > arr[mid - 1])
                L = mid + 1;
            else
                R = mid - 1;
        }
        return -1;
    }
}
