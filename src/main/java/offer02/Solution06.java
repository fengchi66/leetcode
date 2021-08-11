package offer02;

import java.util.Arrays;

// 剑指 Offer II 006. 排序数组中两个数字之和
public class Solution06 {

    public static int[] twoSum(int[] numbers, int target) {
        int L = 0;
        int R = numbers.length - 1;

        while (L < R) {
            if (numbers[L] + numbers[R] == target)
                return new int[]{L, R};
            else if (numbers[L] + numbers[R] < target)
                L++;
            else
                R--;
        }

        return new int[]{};

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5};
        System.out.println(Arrays.toString(twoSum(arr, 5)));

    }
}
