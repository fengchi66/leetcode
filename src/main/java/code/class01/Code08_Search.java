package code.class01;

// 查找第一个大于等于给定值的元素
public class Code08_Search {
    public int search(int[] arr, int n, int value) {

        int low = 0;
        int high = n-1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] >= value) {
                if (mid == 0 || arr[mid -1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }

}
