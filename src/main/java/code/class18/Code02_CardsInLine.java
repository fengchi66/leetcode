package code.class18;

public class Code02_CardsInLine {

    // 根据规则，返回获胜者的分数
    public static int win1(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int first = f1(arr, 0, arr.length - 1);
        int second = g1(arr, 0, arr.length - 1);

        return Math.max(first, second);
    }

    // 递归：arr[L...R],返回先手获得的最好分数
    public static int f1(int[] arr, int L, int R) {
        if (L == R) return arr[L];

        // 不止一张牌，可以拿L也可以拿R
        int p1 = arr[L] + g1(arr, L + 1, R);
        int p2 = arr[R] + g1(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    // 递归：arr[L...R],返回先手获得的分数
    public static int g1(int[] arr, int L, int R) {
        if (L == R) return 0;

        // 先手拿了L或者R
        int p1 = f1(arr, L + 1, R);
        int p2 = f1(arr, L, R - 1);
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 5, 7, 4, 4, 6, 1, 7, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(win1(arr));
    }

}
