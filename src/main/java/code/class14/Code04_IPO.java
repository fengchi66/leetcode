package code.class14;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Code04_IPO {

    /**
     * @param K 最多K个项目
     * @param W W是初始资金
     * @param Profits Profits[] Capital[] 一定等长
     * @param Capital 利润
     * @return 返回最终最大的资金
     */
    public static int findMaximizedCapital(int K, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Program> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Program> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Program(Profits[i], Capital[i]));
        }

        for (int i = 0; i < K; i++) {
            // 把当前能做的项目放到大根堆
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            // 从大根堆弹出利润
            W += maxProfitQ.poll().p;
        }
        return W;
    }

    public static class MinCostComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.c - o2.c;
        }
    }

    public static class MaxProfitComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o2.p - o1.p;
        }
    }

    public static class Program {
        public int p; // 花费
        public int c; // 利润

        public Program(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

}
