package code.class19;


public class Code01_Knapsack {

    // 所有的货物,重量和价值，都在w和vs数组中，bag是背包最大容量
    // 返回不超重的情况下，得到的最大价值
    public static int maxValue(int[] w, int[] v, int bag) {

        if (w == null || v == null || w.length != v.length || w.length == 0)
            return 0;

        // 尝试函数,总左到右一次选货物，加入到背包中
        return process(w, v, 0, bag);
    }

    // 尝试函数
    // 当前考虑到了index号货物，index...的所有货物可以自由选择，做的选择不能超过背包容量，返回最大价值
    public static int process(int[] w, int[] v, int index, int rest) {
        // base case,背包容量小于0了或者没有货物可以选择了
        // 可能加上一个货物后，导致bag < 0,此时这个货物就不能加；设置一个base case的值为-1，当递归调用的返回结果为-1的时候，就不要加上这个货物.
        if (rest < 0) return -1;
        if (index == w.length) return 0;

        // index没到最后，还有货可以选，背包还有空间
        // 不要当前的货
        int p1 = process(w, v, index + 1, rest);
        // 要当前的货: 当前货的最大价值 + 剩余货的最大价值
        int p2 = 0;
        int next = process(w, v, index + 1, rest - w[index]);
        if (next != -1)
            p2 = v[index] + next;

        return Math.max(p1, p2);
    }

    // index 0-N
    // rest 剩余重量 负数-bag
    public static int maxValue2(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0)
            return 0;

        int N = w.length;
        // 行 表示index 0-N；列 表示rest 负-bag
        int[][] dp = new int[N + 1][bag + 1];
        // dp[N][...] = 0
        // 画一张表，行表示index，列表示rest；index从N-1位置由下往上填，dp的值只存在列之间的依赖，rest顺序怎么填都行。
        // 自下而上的动态规划，也就是从base case开始，找依赖关系，依次填表。
        for (int index = N - 1; index >= 0; index--) {
            // 填表
            for (int rest = 0; rest <= bag; rest++) {
                // 不要index位置的或
                int p1 = dp[index + 1][rest];
                // 要index位置的货物，但要判断要上index后是否让剩余背包空间小于0了，不小于0才能要当前的货物
                int p2 = 0;
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1)
                    p2 = v[index] + next;
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] w = {3, 2, 4, 7};
        int[] v = {5, 6, 3, 19};
        int bag = 11;
        System.out.println(maxValue(w, v, bag));
    }

}
