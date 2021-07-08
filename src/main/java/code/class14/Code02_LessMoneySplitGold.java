package code.class14;

import java.util.PriorityQueue;

/**
 * 小根堆：分割黄金
 */
public class Code02_LessMoneySplitGold {

    public static int lessMoney(int[] arr) {
        // 优先队列默认就是小根堆
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }

        int sum = 0; // 一开始需要的铜片长度是0
        int cur = 0; // 用于弹出小根堆中的两个数合并成cur

        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            // 把弹出的两个数之和放到小根堆去
            pQ.add(cur);
        }

        return sum;
    }
}
