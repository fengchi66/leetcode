package code.class01;

// 查找最后一个值等于给定值的元素
public class Code07_Search {

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
                if (mid == n-1 || arr[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
