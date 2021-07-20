package code.class24;

import java.util.Arrays;
import java.util.LinkedList;

public class Code01_SlidingWindowMaxArray {

    // 暴力的对数期方法:分别求每个窗口内的最大值
    public static int[] right(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w)
            return null;

        int[] res = new int[arr.length - w + 1];
        int index = 0;
        int L = 0;
        int R = w - 1;
        while (R < arr.length) {
            int max = arr[L];
            for (int i = L + 1; i <= R; i++) {
                max = Math.max(max, arr[i]);
            }
            res[index++] = max;
            L++;
            R++;
        }
        return res;
    }

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        // qmax 窗口最大值的更新结构
        // 放下标
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        // 遍历数组：每前进一次就是一个窗口
        for (int R = 0; R < arr.length; R++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                qmax.pollLast();
            }
            qmax.addLast(R);
            // 移除过期的下标
            if (qmax.peekFirst() == R - w) {
                qmax.pollFirst();
            }
            // 是否形成一个有效的窗口
            if (R >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        System.out.println(Arrays.toString(right(arr, w)));

    }
}
