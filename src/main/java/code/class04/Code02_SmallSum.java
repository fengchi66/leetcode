package code.class04;

/**
 * 给定一个整数数组 *nums*，返回数组中每个位置左边比他小的数的累加和。
 */
public class Code02_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    /**
     * 每个位置左边有多少个比他小的数 <=> 对i位置而言，右边有X个比i位置大的数，就产生X个i
     */
    public static int process(int[] arr, int L, int R) {

        return 0;

    }



}
