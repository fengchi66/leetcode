package code.class02;

import java.util.Arrays;

/**
 * 递归
 * 求arr中的最大值
 */
public class Code08_GetMax {

    // 求arr中的最大值
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值  L ... R   N
    public static int process(int[] arr, int L, int R) {
        // arr[L..R]范围上只有一个数，直接返回，base case
        if (L == R) {
            return arr[L];
        }
        // L...R 不只一个数
        // mid = (L + R) / 2
        int mid = L + ((R - L) >> 1); // 中点   	1
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int []arr = gennerateArray(000010000, 10000000);
        Arrays.sort(arr);
    }


    public static int[]  gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }

}
