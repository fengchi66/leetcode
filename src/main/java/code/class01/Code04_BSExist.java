package code.class01;

// 二分查找
public class Code04_BSExist {
    public static int search(int[] arr, int num) {
        if (arr == null || arr.length == 0)
            return -1;

        int L = 0;
        int R = arr.length - 1;

        while (L <= R) {
            // 1.首先在中间位置
            int mid = L + ((R - L) >> 1);
            // 2.如果小于num，L右移缩小一半范围
            if (arr[mid] < num)
                L = mid + 1;
            // 3.如果小于num，R左移缩小一半范围
            else if (arr[mid] > num)
                R = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(search(arr, 0));
    }
}

