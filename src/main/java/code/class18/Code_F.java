package code.class18;

/**
 * 斐波拉契数列
 */
public class Code_F {

    public static int f(int N) {
        if (N == 1 || N == 2) return 1;

        return f(N -1) + f(N -2);
    }

    public static void main(String[] args) {
        System.out.println(f(50));
    }
}

