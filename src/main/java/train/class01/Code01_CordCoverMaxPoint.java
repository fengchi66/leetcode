package train.class01;

/**
 * 给定一个有序数组arr，从左到右依次表示X轴上从左往右点的位置，给定一个正整数K，
 * 返回如果有一根长度为K的绳子，最多能盖住几个点，绳子的边缘点碰到X轴上的点，也算盖住。
 */
public class Code01_CordCoverMaxPoint {

    // 滑动窗口
    public static int maxPoint(int[] arr, int K) {
        if (arr == null || arr.length == 0)
            return 0;
        int L = 0, R = 0, max = 0;
        int n = arr.length;

        while (L < n) {
            while (R < n && arr[R] - arr[L] <= K)
                R++;
            max = Math.max(max, R - L);
            L++;
        }
        return max;
    }
}
