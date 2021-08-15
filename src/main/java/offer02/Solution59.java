package offer02;

import java.util.PriorityQueue;

// 剑指 Offer II 059. 数据流的第 K 大数值
public class Solution59 {
    private PriorityQueue<Integer> minHeap;
    private int size;

    // 使用整数 k 和整数流 nums 初始化对象。
    public Solution59(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }

    }

    // 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。
    public int add(int val) {
        // 如果当前最小堆的大小还小于k，那么直接将该元素添加进去
        if (minHeap.size() < size) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) { // 最小堆已经有k个元素了，则判断当前元素是不是比堆顶的大
            minHeap.poll();
            minHeap.offer(val);
        }

        // 返回第k大的元素
        return minHeap.peek();
    }
}
