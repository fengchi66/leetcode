package code.class04;

// 归并排序
public class Code01_MergeSort {

    /**
     * 递归方式实现归并排序
     */
    public static void mergerSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上变成有序的
    public static void process(int[] arr, int L, int R) {
        // base case
        if (L == R) return;

        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    // 此时可以认为L -> M, M+1 -> R上已经是有序的了
    public static void merge(int[] arr, int L, int M, int R) {
        // 辅助数组的长度是L -> R上元素的个数
        int[] help = new int[R - L + 1];
        int i = 0;

        // 准备两个指针,一开始分别指向L、M +1位置
        int p1 = L;
        int p2 = M + 1;

        // p1、p2都不越界
        // 如果p1位置数小于p2位置的数，将p1拷贝到i位置上，同时p1++；反之将p2拷贝到i位置上，同时p2++；
        // 不管拷贝谁，都要i++
        while (p1 <= M && p2 <= R)
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];

        // 要么p1越界了，要么p2越界了
        while (p1 <= M) help[i++] = arr[p1++];
        while (p2 <= R) help[i++] = arr[p2++];

        // 将L -> R上排序好的数据拷贝到原数据arr中
        for (i = 0; i < help.length; i++)
            arr[L + i] = help[i];
    }

    /**
     * 非递归方式实现归并排序
     */
    public static void mergerSort2(int[] arr) {
        if (arr == null || arr.length < 2)
            return;




    }

}
