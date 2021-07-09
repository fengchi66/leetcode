package code.class17;

/**
 * 汉诺塔游戏
 */
public class Code02_Hanoi {

    public static void hanoi1(int n) {
        leftToRight(n);
    }

    // 请把1-N层圆盘，从左 -> 右
    public static void leftToRight(int n) {
        // base case
        if (n == 1) {
            System.out.println("Move 1 from left to right");
            return;
        }

        leftToMid(n - 1);
        System.out.println("Move " + n + " from left to right");
        midToRight(n - 1);
    }

    // 请把1~N层圆盘 从左 -> 中
    public static void leftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to mid");
            return;
        }
        leftToRight(n - 1);
        System.out.println("Move " + n + " from left to mid");
        rightToMid(n - 1);
    }


    public static void rightToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to mid");
            return;
        }
        rightToLeft(n - 1);
        System.out.println("Move " + n + " from right to mid");
        leftToMid(n - 1);
    }

    public static void midToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to right");
            return;
        }
        midToLeft(n - 1);
        System.out.println("Move " + n + " from mid to right");
        leftToRight(n - 1);
    }

    public static void midToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to left");
            return;
        }
        midToRight(n - 1);
        System.out.println("Move " + n + " from mid to left");
        rightToLeft(n - 1);
    }

    public static void rightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to left");
            return;
        }
        rightToMid(n - 1);
        System.out.println("Move " + n + " from right to left");
        midToLeft(n - 1);
    }


    /**
     * @param N
     * @param from 1 - N: 在from
     * @param to 要去：to
     * @param other 另一个：other
     */
    public static void func(int N, String from, String to, String other) {
        // base case
        if (N == 1)
            System.out.println("Move 1 from " + from + " to " + to);
        else {
            // 此时的N -1在from，去到other
            func(N - 1, from, other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            // 此时N -1 在other，去到to
            func(N - 1, other, to, from);
        }
    }

    public static void main(String[] args) {
        func(64, "A", "C", "B");
    }



}
