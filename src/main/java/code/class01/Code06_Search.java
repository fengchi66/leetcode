package code.class01;

// 二分变体：查找第一个值等于给定值的元素
public class Code06_Search {

    public int search(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < value)
                low = mid + 1;
            else if (arr[mid] > value)
                high = mid - 1;
            else {
                if (mid == 0 || arr[mid] != value) return mid;
                else high = mid - 1;
            }

        }
        return -1;
    }
}
